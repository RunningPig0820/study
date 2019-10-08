package client.remoteServer;

import service.bean.RpcRequest;
import serviceDiscovery.IServiceDiscovery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**

 */
public class RemoteInvocationHandler implements InvocationHandler {
    private IServiceDiscovery serviceDiscovery;

    private String version;

    public RemoteInvocationHandler(IServiceDiscovery serviceDiscovery, String version) {
        this.serviceDiscovery=serviceDiscovery;
        this.version=version;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //组装请求
        RpcRequest request=new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        request.setVersion(version);

        String serviceAddress=serviceDiscovery.discover(request.getClassName()); //根据接口名称得到对应的服务地址

        serviceAddress = "127.0.0.1:8080";

        System.out.println(request);
        System.out.println(serviceAddress);
        //通过tcp传输协议进行传输
        TCPTransport tcpTransport=new TCPTransport(serviceAddress);
        //发送请求
        return tcpTransport.send(request);
    }
}
