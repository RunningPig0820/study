package com.taosha.summaryframework.customData.configuration;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-15 1:48 PM
 **/
@Slf4j
public class BaseDaoConfiguration {
    private Map<String, Object> datasourceMap;

    @Value("${mysql.minIdle:1}")
    protected String minIdle;

    @Value("${mysql.maxWait:20000}")
    protected String maxWait;

    @Value("${mysql.removeAbandoned:true}")
    protected String removeAbandoned;

    @Value("${mysql.removeAbandonedTimeout:180}")
    protected String removeAbandonedTimeout;

    @Value("${mysql.timeBetweenEvictionRunsMillis:60000}")
    protected String timeBetweenEvictionRunsMillis;

    @Value("${mysql.minEvictableIdleTimeMillis:300000}")
    protected String minEvictableIdleTimeMillis;

    @Value("${mysql.validationQuery:SELECT 1}")
    protected String validationQuery;

    @Value("${mysql.testWhileIdle:true}")
    protected String testWhileIdle;

    @Value("${mysql.testOnBorrow:false}")
    protected String testOnBorrow;

    @Value("${mysql.testOnReturn:false}")
    protected String testOnReturn;

    @Value("${mysql.poolPreparedStatements:true}")
    protected String poolPreparedStatements;

    @Value("${mysql.maxPoolPreparedStatementPerConnectionSize:50}")
    protected String maxPoolPreparedStatementPerConnectionSize;

    @Value("${mysql.initConnectionSqls:SELECT 1}")
    protected String initConnectionSqls;

    @Value("${mysql.driverClassName}")
    protected String driverClassName;

    /**
     * 初始化配置
     */
    protected void initDaoConfig() {
        datasourceMap.put("minIdle", minIdle);
        datasourceMap.put("maxWait", maxWait);
        datasourceMap.put("removeAbandoned", removeAbandoned);
        datasourceMap.put("removeAbandonedTimeout", removeAbandonedTimeout);
        datasourceMap.put("timeBetweenEvictionRunsMillis", timeBetweenEvictionRunsMillis);
        datasourceMap.put("minEvictableIdleTimeMillis", minEvictableIdleTimeMillis);
        datasourceMap.put("validationQuery", validationQuery);
        datasourceMap.put("testWhileIdle", testWhileIdle);
        datasourceMap.put("testOnBorrow", testOnBorrow);
        datasourceMap.put("testOnReturn", testOnReturn);
        datasourceMap.put("poolPreparedStatements", poolPreparedStatements);
        datasourceMap.put("maxPoolPreparedStatementPerConnectionSize", maxPoolPreparedStatementPerConnectionSize);
        datasourceMap.put("initConnectionSqls", initConnectionSqls);

        datasourceMap.put("driverClassName", driverClassName);

    }

    protected DataSource getDataSource(String url, String user, String pass) {
        datasourceMap.put(DruidDataSourceFactory.PROP_URL, url);
        datasourceMap.put(DruidDataSourceFactory.PROP_USERNAME, user);
        datasourceMap.put(DruidDataSourceFactory.PROP_PASSWORD, pass);

        try {
            return DruidDataSourceFactory.createDataSource(datasourceMap);
        } catch (Exception e) {
            log.error("无法获得数据源[{}]:[{}]", url, ExceptionUtils.getStackTrace(e));
            throw new RuntimeException("无法获得数据源.");
        }
    }

    private void getPropertiesFromSource(PropertySource<?> propertySource, Map<String, Object> map) {
        if (propertySource instanceof MapPropertySource) {
            for (String key : ((MapPropertySource) propertySource).getPropertyNames()) {
                map.put(key, propertySource.getProperty(key));
            }
        }
        if (propertySource instanceof CompositePropertySource) {
            for (PropertySource<?> s : ((CompositePropertySource) propertySource).getPropertySources()) {
                getPropertiesFromSource(s, map);
            }
        }
    }
}
