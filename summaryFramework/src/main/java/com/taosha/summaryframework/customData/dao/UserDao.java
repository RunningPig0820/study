package com.taosha.summaryframework.customData.dao;

import com.taosha.summaryframework.customData.entity.User;
import com.taosha.summaryframework.customData.utils.JdbcUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-15 11:55 AM
 **/
public class UserDao extends AbstractDao<User>{

    @Resource(name = "templateUser")
    private JdbcTemplate jdbcTemplate;

    public User getUser(Long userId){
//        Map<String, Object> criteria = new HashMap<>();
//        criteria.put("USE_ID", userId);
//        try {
//            JdbcUtils.JdbcResult jdbcResult = JdbcUtils.getSelect(this.getTableName(mappingId), AlipayContacts.class, getEntityToDbMap(), criteria, null);
//            Map<String, Object> dbRow = this.getTemplate().queryForMap(jdbcResult.getSql(), jdbcResult.getParams());
//            return JdbcUtils.transferDbResultToEntity(dbRow, getEntityToDbMap(), AlipayContacts.class);
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
        return null;
    }

    @Override
    protected String getTableNamePrefix() {
        return "USER";

    }

    @Override
    protected JdbcTemplate getTemplate() {
        return jdbcTemplate;
    }
}
