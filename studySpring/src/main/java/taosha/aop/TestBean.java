package taosha.aop;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-09-05 11:29 AM
 **/
public class TestBean {

    private String testStr = "testStr";


    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test(){
        System.out.println("test");
    }
}
