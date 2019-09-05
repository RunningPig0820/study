package taosha.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-09-05 11:30 AM
 **/
@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.test(..))")
    public void test(){

    }

    @Before("test()")
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @After("test()")
    public void afterTest(){
        System.out.println("afterTest");
    }

    @Around("test()")
    public Object arountTest(ProceedingJoinPoint point){
        System.out.println("before1");
        Object object = null;
        try {
            object = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("after1");
        return object;
    }

}
