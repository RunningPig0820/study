package service;

import common.IHelloService;
import service.anno.RpcAnnotation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 */
@RpcAnnotation(IHelloService.class)
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String msg) {
        return "Hello,"+msg;
    }
}
