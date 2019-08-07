package com.taosha;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-05-20 10:45 AM
 **/
public class TestSpring {

    @Test
    public void testValid() throws Exception {
        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.addPropertyValue(new PropertyValue("forname", "Tony"));
        pvs.addPropertyValue(new PropertyValue("surname", "Blair"));
        pvs.addPropertyValue(new PropertyValue("age", "50"));

        Assert.assertTrue("Contains 3", pvs.getPropertyValues().length == 3);
        Assert.assertTrue("Contains forname", pvs.contains("forname"));
        Assert.assertTrue("Contains surname", pvs.contains("surname"));
        Assert.assertTrue("Contains age", pvs.contains("age"));
        Assert.assertTrue("Doesn't contain tory", !pvs.contains("tory"));
    }
}
