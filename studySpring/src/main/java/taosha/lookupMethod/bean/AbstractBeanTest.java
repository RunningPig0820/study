package taosha.lookupMethod.bean;

import taosha.definitionParser.bean.User;

import javax.jws.soap.SOAPBinding;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-07-22 9:32 AM
 **/
public abstract class AbstractBeanTest {
    public void showMe(){
        this.getBean().showMe();
    }

    public abstract Pepole getBean();
}
