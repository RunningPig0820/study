package pattern.proxy.dbrource;



import pattern.proxy.dbrource.proxy.OrderServiceStaticProxy;
import pattern.proxy.dbrource.service.IOrderService;
import pattern.proxy.dbrource.service.Order;
import pattern.proxy.dbrource.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 淘沙
 * @date 2020/08/23 3:21 下午
 */
public class DbRouteProxyTest {
    public static void main(String[] args) {
        try {
            Order order = new Order();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2017/02/01");
//            Date date = sdf.parse("2018/02/01");
            order.setCreateTime(date.getTime());

            IOrderService orderService = (IOrderService)new OrderServiceStaticProxy(new OrderService());
//            IOrderService orderService = (IOrderService)new OrderServiceDynamicProxy().getInstance(new OrderService());
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
