package taosha.replacedMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import taosha.replacedMethod.bean.ChangeMethod;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-07-23 10:06 AM
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("/WEB-INF/replacemethod.xml");
        ChangeMethod test = (ChangeMethod)bf.getBean("changeMethod");
        test.changeMe();
    }
}
