package pattern.proxy.dynamicproxy.jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created by Tom on 2019/3/10.
 */
public class JDKProxyTest {

    public void jdkProxyTest(){
        try {

            Person person = (Person)new JDKMeipo().getInstance(new Girl());
            person.findLove();

            //$Proxy0
            byte [] bytes = ProxyGenerator.generateProxyClass("JDKProxyTest$Proxy0",new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("./studyPattern/src/main/java/pattern/proxy/dynamicproxy/JDKProxyTest$Proxy0.class");
            os.write(bytes);
            os.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JDKProxyTest jdkProxyTest = new JDKProxyTest();
        jdkProxyTest.jdkProxyTest();
    }

}
