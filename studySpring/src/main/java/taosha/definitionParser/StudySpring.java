package taosha.definitionParser;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import taosha.definitionParser.bean.User;

/**
 * @ClassName studySpring
 * @Description TODO
 * @Author zhangMin
 * @Date 2019/2/25 15:15
 * @Version 1.0
 **/
public class StudySpring {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.getUserName() + "----" + user.getEmail());

        Resource resource = new ClassPathResource("spring.xml");
        BeanFactory bf = new XmlBeanFactory(resource);
    }
}
