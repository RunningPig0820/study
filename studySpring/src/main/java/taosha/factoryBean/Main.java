package taosha.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import taosha.factoryBean.bean.Car;
import taosha.replacedMethod.bean.ChangeMethod;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-07-23 10:06 AM
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("/WEB-INF/carFactory.xml");
        CarFactoryBean test = (CarFactoryBean)bf.getBean("&car");
        System.out.println(test);

        Car car = (Car)bf.getBean("car");
        System.out.println(car);
    }
}
