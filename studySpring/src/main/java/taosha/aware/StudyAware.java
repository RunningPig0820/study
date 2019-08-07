package taosha.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-05-20 1:51 PM
 **/
public class StudyAware {
    public static void main(String[] args) {
//        ClassPathResource resource = new ClassPathResource("spring.xml");
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(resource);
//        MyApplicationAware applicationAware = (MyApplicationAware) factory.getBean("myApplicationAware");
//        applicationAware.display();

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        MyApplicationAware applicationAware = (MyApplicationAware) context.getBean("myApplicationAware");
        applicationAware.display();
    }
}
