package client.remoteServer;

import serviceDiscovery.IServiceDiscovery;

import java.lang.reflect.Proxy;

/**
 *
 */
public class RpcClientProxy {

    private IServiceDiscovery serviceDiscovery;

    public RpcClientProxy(IServiceDiscovery serviceDiscovery) {
        this.serviceDiscovery = serviceDiscovery;
    }

    /**
     * 创建客户端的远程代理。通过远程代理进行访问
     *
     * @param interfaceCls
     * @param <T>
     * @return
     */
    public <T> T clientProxy(final Class<T> interfaceCls, String version) {
        //使用到了动态代理。
        return (T) Proxy.newProxyInstance(
                interfaceCls.getClassLoader(),
                new Class[]{interfaceCls},
                new RemoteInvocationHandler(serviceDiscovery, version));
    }


}
