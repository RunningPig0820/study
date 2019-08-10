package taosha.circularDependency;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import taosha.circularDependency.bean.ConstructorA;
import taosha.circularDependency.bean.ConstructorB;
import taosha.circularDependency.bean.PropertyA;
import taosha.circularDependency.bean.PropertyB;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-09 2:10 PM
 **/
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/WEB-INF/circularDependency.xml");

        //当循环依赖的bean都是通过构造器注入依赖的时候，无论这些bean是singleton还是prototype，在获取bean的时候都会失败。
        System.out.println("\n当循环依赖的bean都是通过构造器注入依赖的时\n");
        main.test3(applicationContext);
        main.test2(applicationContext);
        main.test1(applicationContext);

        //循环依赖的bean都是通过属性注入的情况
        System.out.println("\n循环依赖的bean都是通过属性注入的情况\n");
        //TODO test7 顺序不一样 结论不一样 运行是注释一个
        main.test8(applicationContext);
        //TODO test8 顺序不一样 结论不一样 运行是注释一个
        main.test7(applicationContext);
        main.test6(applicationContext);
        main.test6(applicationContext);
        main.test5(applicationContext);
        main.test4(applicationContext);

        //循环依赖的bean同时有属性注入和构造器注入的情况
        System.out.println("\n循环依赖的bean同时有属性注入和构造器注入的情况\n");


        //结论
        System.out.println("\n如果多个bean存在循环依赖，在Spring容器启动后，只有当获取的第一个bean是通过属性注入依赖的singleton时，才会成功，别的情况都会失败\n");


//        for(int i=0;i   for(intj=0;j     for(intk=0;k      System.out.print("out");     }   }}
//        }
    }

    public void test1(ApplicationContext applicationContext){
        try {
            ConstructorA constructorA = (ConstructorA) applicationContext.getBean("singletonA");
            System.out.println("成功 初始化A-singleton:循环依赖的bean都是singleton");
        }catch(BeanCreationException e){
            System.out.println("异常 初始化A-singleton:循环依赖的bean都是singleton");
        }

        try {
            ConstructorB constructorB = (ConstructorB) applicationContext.getBean("singletonB");
            System.out.println("成功 初始化B-singleton:循环依赖的bean都是singleton");
        }catch (BeanCreationException e){
            System.out.println("异常 初始化B-singleton:循环依赖的bean都是singleton");
        }
    }


    public void test2(ApplicationContext applicationContext){
        try {
            ConstructorA constructorA = (ConstructorA) applicationContext.getBean("propertyA");
            System.out.println("成功 初始化A-prototype:循环依赖的bean都是prototype");
        }catch(BeanCreationException e){
            System.out.println("异常 初始化A-prototype:循环依赖的bean都是prototype");
        }

        try {
            ConstructorB constructorB = (ConstructorB) applicationContext.getBean("propertyB");
            System.out.println("成功 初始化B-prototype:循环依赖的bean都是prototype");
        }catch (BeanCreationException e){
            System.out.println("异常 初始化B-prototype:循环依赖的bean都是prototype");
        }
    }

    public void test3(ApplicationContext applicationContext){
        try {
            ConstructorA constructorA = (ConstructorA) applicationContext.getBean("mixSingletonA");
            System.out.println("成功 初始化A-mixSingleton:循环依赖的bean同时有singleton和prototype");
        }catch(BeanCreationException e){
            System.out.println("异常 初始化A-mixSingleton:循环依赖的bean同时有singleton和prototype");
        }

        try {
            ConstructorB constructorB = (ConstructorB) applicationContext.getBean("mixPrototypeB");
            System.out.println("成功 初始化B-mixSingleton:循环依赖的bean同时有singleton和prototype");
        }catch (BeanCreationException e){
            System.out.println("异常 初始化B-mixSingleton:循环依赖的bean同时有singleton和prototype");
        }
    }


    public void test4(ApplicationContext applicationContext){
        try {
            PropertyA propertyA = (PropertyA) applicationContext.getBean("propertyA-singleton");
            System.out.println("成功 初始化A-property-singleton-singleton: 循环依赖的bean都是singleton");
        }catch(BeanCreationException e){
            System.out.println("异常 初始化ApropertyA-singleton-singleton: 循环依赖的bean都是singleton");
        }

        try {
            PropertyB propertyB = (PropertyB) applicationContext.getBean("propertyB-singleton");
            System.out.println("成功 初始化B-property-singleton-singleton: 循环依赖的bean都是singleton");
        }catch (BeanCreationException e){
            System.out.println("异常 初始化B-property-singleton-singleton: 循环依赖的bean都是singleton");
        }
    }

    public void test5(ApplicationContext applicationContext){
        try {
            PropertyA propertyA = (PropertyA) applicationContext.getBean("propertyA-prototype");
            System.out.println("成功 初始化A-property-prototype-prototype: 循环依赖的bean都是prototype");
        }catch(BeanCreationException e){
            System.out.println("异常 初始化A-property-prototype-prototype: 循环依赖的bean都是prototype");
        }

        try {
            PropertyB propertyB = (PropertyB) applicationContext.getBean("propertyB-prototype");
            System.out.println("成功 初始化B-property-prototype-prototype: 循环依赖的bean都是prototype");
        }catch (BeanCreationException e){
            System.out.println("异常 初始化B-property-prototype-prototype: 循环依赖的bean都是prototype");
        }
    }

    public void test6(ApplicationContext applicationContext){
        try {
            PropertyA propertyA = (PropertyA) applicationContext.getBean("propertyA-mixSingleton");
            System.out.println("成功 初始化A-property-mixSingleton-singleton: 循环依赖的bean同时有singleton和prototype");
        }catch(BeanCreationException e){
            System.out.println("异常 初始化A-property-mixSingleton-singleton: 循环依赖的bean同时有singleton和prototype");
        }

        try {
            PropertyB propertyB = (PropertyB) applicationContext.getBean("propertyB-mixPrototype");
            System.out.println("成功 初始化B-property-mixPrototype-prototype: 循环依赖的bean同时有singleton和prototype");
        }catch (BeanCreationException e){
            System.out.println("异常 初始化B-property-mixPrototype-prototype: 循环依赖的bean同时有singleton和prototype");
        }
    }

    /**
     * test8顺序不同 结果不一样
     */
    public void test7(ApplicationContext applicationContext){
        try {
            PropertyB propertyB = (PropertyB) applicationContext.getBean("propertyB-mixPrototype");
            System.out.println("成功 初始化B-property-mixPrototype-prototype: 循环依赖的bean同时有singleton和prototype");
        }catch (BeanCreationException e){
            System.out.println("异常 初始化B-property-mixPrototype-prototype: 循环依赖的bean同时有singleton和prototype");
        }

        try {
            PropertyA propertyA = (PropertyA) applicationContext.getBean("propertyA-mixSingleton");
            System.out.println("成功 初始化A-property-mixSingleton-singleton: 循环依赖的bean同时有singleton和prototype");
        }catch(BeanCreationException e){
            System.out.println("异常 初始化A-property-mixSingleton-singleton: 循环依赖的bean同时有singleton和prototype");
        }
    }

    public void test8(ApplicationContext applicationContext){
        try {
            PropertyA propertyA = (PropertyA) applicationContext.getBean("propertyA-mixSingleton");
            System.out.println("成功 初始化A-property-mixSingleton-singleton: 循环依赖的bean同时有singleton和prototype");
        }catch(BeanCreationException e){
            System.out.println("异常 初始化A-property-mixSingleton-singleton: 循环依赖的bean同时有singleton和prototype");
        }


        try {
            PropertyB propertyB = (PropertyB) applicationContext.getBean("propertyB-mixPrototype");
            System.out.println("成功 初始化B-property-mixPrototype-prototype: 循环依赖的bean同时有singleton和prototype");
        }catch (BeanCreationException e){
            System.out.println("异常 初始化B-property-mixPrototype-prototype: 循环依赖的bean同时有singleton和prototype");
        }
    }
}
