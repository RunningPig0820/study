package taosha.propertyEditor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-09-04 10:45 AM
 **/
public class DatePropertyEditor extends PropertyEditorSupport{

    private String format = "yyyy-MM-dd";

    public void setFormat(String format){
        this.format = format;
    }

    @Override
    public void setAsText(String arg0) throws IllegalArgumentException{
        System.out.println("arg0 : " + arg0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = simpleDateFormat.parse(arg0);
            this.setValue(date);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
