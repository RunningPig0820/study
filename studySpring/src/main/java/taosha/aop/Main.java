package taosha.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import taosha.event.TestEvent;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-09-05 10:09 AM
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/aop.xml");
        TestBean testEvent = (TestBean) context.getBean("test");
        testEvent.test();
    }
}
