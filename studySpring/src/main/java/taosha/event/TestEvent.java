package taosha.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-09-05 10:05 AM
 **/
public class TestEvent extends ApplicationEvent{
    public  String msg;

    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source,String msg){
        super(source);
        this.msg = msg;
    }

    public void print(){
        System.out.println(msg);
    }

}
