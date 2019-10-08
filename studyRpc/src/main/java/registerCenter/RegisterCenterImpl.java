package registerCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 注册中心
 */
public class RegisterCenterImpl implements IRegisterCenter {


    @Override
    public void register(String serviceName, String serviceAddress) {

        String addressList = (String) Depository.registerMap.get(serviceName);
        if(addressList == null){
            Depository.registerMap.put(serviceName,serviceAddress);
        }else{
            addressList = addressList + ":" + serviceAddress;
            Depository.registerMap.put(serviceName,addressList);
        }

    }
}
