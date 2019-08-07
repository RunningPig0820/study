package taosha.replacedMethod.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-07-23 10:07 AM
 **/
public class ChangeMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("方法替换");
        return null;
    }
}
