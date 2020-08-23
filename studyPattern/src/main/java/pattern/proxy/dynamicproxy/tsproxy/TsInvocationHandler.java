package pattern.proxy.dynamicproxy.tsproxy;

import java.lang.reflect.Method;

/**
 * @author 淘沙
 * @date 2020/08/23 4:26 下午
 */
public interface TsInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
