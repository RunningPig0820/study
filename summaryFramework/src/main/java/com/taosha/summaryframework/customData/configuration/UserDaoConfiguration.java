package com.taosha.summaryframework.customData.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-15 1:46 PM
 **/

//事物注解
@EnableTransactionManagement
@Configuration
@ConditionalOnProperty(value = {"mysql.enabled"}, matchIfMissing = true)
@Slf4j
public class UserDaoConfiguration extends BaseDaoConfiguration{
    @Value("${user.mysql.url}")
    private String moxiezmUrl;

    @Value("${user.mysql.user}")
    private String moxiezmUser;

    @Value("${user.mysql.pass}")
    private String moxiezmPass;

    @Value("${user.mysql.initial.size:20}")
    private String initialSize;

    @Value("${user.mysql.max.active:50}")
    private String maxActive;

    @Bean(name = "dataSourceUser")
    @Qualifier("dataSourceUser")
    public DataSource dataSourceMoxiezm() {
        log.debug("初始化数据源 user");
        return this.getDataSource(moxiezmUrl, moxiezmUser, moxiezmPass);
    }

    @Bean(name = "templateUser")
    public JdbcTemplate templateUser() {
        return new JdbcTemplate(this.dataSourceMoxiezm());
    }
}
