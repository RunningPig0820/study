package taosha.event;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-09-05 10:09 AM
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/event.xml");
        TestEvent testEvent = new TestEvent("hello","msg");
        context.publishEvent(testEvent);
    }
}
