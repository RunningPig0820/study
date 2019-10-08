package service;

import common.IHelloService;
import registerCenter.IRegisterCenter;
import registerCenter.RegisterCenterImpl;
import service.remoteServer.RpcServer;

import java.io.IOException;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class Server {

    public static void main(String[] args) throws IOException {
        IHelloService iHelloService = new HelloServiceImpl();

        IRegisterCenter registerCenter = new RegisterCenterImpl();

        RpcServer rpcServer= new RpcServer(registerCenter,"127.0.0.1:8080");
        rpcServer.bind(iHelloService);
        rpcServer.publisher();

        System.in.read();
    }
}
