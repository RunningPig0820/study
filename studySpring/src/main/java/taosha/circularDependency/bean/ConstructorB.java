package taosha.circularDependency.bean;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-09 2:10 PM
 **/
public class ConstructorB {
    private ConstructorA constructorA;

    public ConstructorB(ConstructorA constructorA) {
    }

    public ConstructorA getConstructorB() {
        return constructorA;
    }
}
