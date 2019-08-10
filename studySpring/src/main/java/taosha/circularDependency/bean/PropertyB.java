package taosha.circularDependency.bean;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-09 2:45 PM
 **/
public class PropertyB {
    private PropertyA propertyA;

    public PropertyA getPropertyA() {
        return propertyA;
    }

    public void setPropertyA(PropertyA propertyA) {
        this.propertyA = propertyA;
    }
}
