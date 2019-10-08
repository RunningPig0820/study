package registerCenter;

import java.util.HashMap;
import java.util.List;

/**
 * 注册中心
 */
public interface IRegisterCenter {

    /**
     * 注册服务名称和服务地址
     * @param serviceName
     * @param serviceAddress
     */
    void register(String serviceName, String serviceAddress);
}
