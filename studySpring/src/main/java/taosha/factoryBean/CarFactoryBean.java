package taosha.factoryBean;

import com.sun.tools.javac.tree.JCTree;
import org.springframework.beans.factory.FactoryBean;
import taosha.factoryBean.bean.Car;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-12 7:44 PM
 **/
public class CarFactoryBean implements FactoryBean<Car>{

    private String carInfo;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split("," );
        car.setBrand(infos[0]);
        car.setBrand(infos[1]);
        car.setBrand(infos[2]);
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getCarInfo(){
        return carInfo;
    }

    public void setCarInfo(String carInfo){
        this.carInfo = carInfo;
    }

    @Override
    public String toString() {
        return "CarFactoryBean{" +
                "carInfo='" + carInfo + '\'' +
                '}';
    }
}
