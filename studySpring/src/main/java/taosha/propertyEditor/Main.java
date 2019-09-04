package taosha.propertyEditor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-09-04 10:12 AM
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/propertyEditor.xml");
        UserManager userManager = (UserManager) context.getBean("userManager");
        System.out.println(userManager);
    }
}
