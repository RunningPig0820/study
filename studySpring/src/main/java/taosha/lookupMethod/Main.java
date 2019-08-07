package taosha.lookupMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import taosha.lookupMethod.bean.AbstractBeanTest;
import taosha.lookupMethod.bean.Pepole;

/**
 * @Description : 解析子元素 lookup-method
 * @Author : zhangmin
 * @Data 2019-07-22 9:28 AM
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("/WEB-INF/lookupTest.xml");
        AbstractBeanTest test = (AbstractBeanTest)bf.getBean("getBeanTest");
        test.showMe();
    }
}
