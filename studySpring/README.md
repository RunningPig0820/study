# studySpring

## 使用自定义标签
1. 扩展 Spring 自定义标签配置一般需要以下几个步骤：
创建一个需要扩展的组件。
2. 定义一个 XSD 文件，用于描述组件内容。
3. 创建一个实现 org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser 接口的类，用来解析 XSD 文件中的定义和组件定义。
4. 创建一个 Handler，继承 org.springframework.beans.factory.xml.NamespaceHandlerSupport 抽象类 ，用于将组件注册到 Spring 容器。
编写 spring.handlers 和 Spring.schemas 文件。
5. 下面就按照上面的步骤来实现一个自定义标签组件。