package serviceDiscovery;

/**
 * 服务发现
 */
public interface IServiceDiscovery {

    /**
     * 根据请求的服务地址，获得对应的调用地址
     * @param serviceName
     * @return
     */
    String discover(String serviceName);
}
