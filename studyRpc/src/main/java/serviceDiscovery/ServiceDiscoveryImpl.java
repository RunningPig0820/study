package serviceDiscovery;

import loadbalance.LoadBalance;
import loadbalance.RandomLoadBalance;
import registerCenter.Depository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ServiceDiscoveryImpl implements IServiceDiscovery{
    @Override
    public String discover(String serviceName) {
        String address;

        try {
            address= (String)Depository.registerMap.get(serviceName);
        } catch (Exception e) {
            throw new RuntimeException("获取子节点异常："+e);
        }

//        //负载均衡机制
//        LoadBalance loadBalance = new RandomLoadBalance();
//        //返回调用的服务地址
//        loadBalance.selectHost();

        return address;
    }

}
