package taosha.circularDependency.bean;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-09 2:10 PM
 **/
public class ConstructorA {
    private ConstructorB constructorB;

    public ConstructorA(ConstructorB constructorB) {
    }

    public ConstructorB getConstructorB() {
        return constructorB;
    }
}
