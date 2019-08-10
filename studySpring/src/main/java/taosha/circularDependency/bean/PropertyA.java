package taosha.circularDependency.bean;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-09 2:45 PM
 **/
public class PropertyA {
    private PropertyB propertyB;

    public PropertyB getPropertyB() {
        return propertyB;
    }

    public void setPropertyB(PropertyB propertyB) {
        this.propertyB = propertyB;
    }
}
