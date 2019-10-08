package client;

import client.remoteServer.RpcClientProxy;
import common.IHelloService;
import serviceDiscovery.IServiceDiscovery;
import serviceDiscovery.ServiceDiscoveryImpl;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class ClientDemo {

    public static void main(String[] args) throws InterruptedException {
        IServiceDiscovery serviceDiscovery = new ServiceDiscoveryImpl();

        RpcClientProxy rpcClientProxy = new RpcClientProxy(serviceDiscovery);

//        for(int i=0;i<10;i++) {
            IHelloService hello = rpcClientProxy.clientProxy(IHelloService.class, null);
            System.out.println(hello.sayHello("mic"));
            Thread.sleep(1000);
//        }
    }
}
