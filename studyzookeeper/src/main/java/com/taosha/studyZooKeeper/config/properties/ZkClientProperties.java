package com.taosha.studyZooKeeper.config.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-10 3:37 PM
 **/
@Data
@Component
//@ConfigurationProperties(prefix = "studyZooKeeper")
public class ZkClientProperties {

    /**
     * 链接 地址
     */
    @Value("${studyZooKeeper.zookeeper.connectAddress}")
    private String connectAddress;

    /**
     * 链接超时时间
     */
    @Value("${studyZooKeeper.zookeeper.sessionTimeout}")
    private int sessionTimeout;

}
