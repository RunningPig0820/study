package com.taosha.summaryframework.customData.dao;

import com.taosha.summaryframework.customData.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-15 11:42 AM
 **/
@Slf4j
public abstract class AbstractDao<T extends BaseEntity> {

    protected Map<String, String> entityToDbMap;


    @SuppressWarnings("unchecked")
    @PostConstruct
    protected  void init() {
        try {
            Class<T> clazz = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            entityToDbMap = clazz.newInstance().getEntityToDbMap();
        } catch (Exception e) {
            log.info("实例化对象出错",e);
        }
    }

    protected Map<String, String> getEntityToDbMap(){
        return this.entityToDbMap;
    }

    protected String getTableName(String mappingId) {
        return getTableNamePrefix();
    }


    protected abstract String getTableNamePrefix();

    protected abstract JdbcTemplate getTemplate();
}
