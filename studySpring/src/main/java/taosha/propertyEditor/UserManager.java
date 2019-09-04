package taosha.propertyEditor;

import java.util.Date;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-09-04 10:06 AM
 **/
public class UserManager {

    private Date dataValue;

    public Date getDataValue() {
        return dataValue;
    }

    public void setDataValue(Date dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        return "UserManager{" +
                "dataValue=" + dataValue +
                '}';
    }
}
