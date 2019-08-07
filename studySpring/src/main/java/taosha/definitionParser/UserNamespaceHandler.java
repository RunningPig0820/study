package taosha.definitionParser;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @ClassName UserNamespaceHandler
 * @Description TODO
 * @Author zhangMin
 * @Date 2019/2/25 15:28
 * @Version 1.0
 **/
public class UserNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("user", new UserDefinitionParser());
    }

}
