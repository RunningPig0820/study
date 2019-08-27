package com.taosha.studydruid.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-27 4:33 PM
 **/
@Configuration
@MapperScan(value = "com.taosha.studydruid.dao")
public class UserDbConfig {
    @Value("${mybatis.mapper-locations:classpath:mapping/*.xml}")
    private String mapperPath;

    @Bean("userDataSource")
    @ConfigurationProperties(prefix = "spring")
    public DruidDataSource druidDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("userTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("userDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /** 创建Mybatis的连接会话工厂实例 */
    @Bean("userSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = mapperPath;
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        return sqlSessionFactoryBean.getObject();
    }

}
