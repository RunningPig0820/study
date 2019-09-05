package taosha.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-09-05 10:07 AM
 **/
public class TestListener implements ApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof TestEvent){
            TestEvent testEvent = (TestEvent)applicationEvent;
            testEvent.print();
        }
    }
}
