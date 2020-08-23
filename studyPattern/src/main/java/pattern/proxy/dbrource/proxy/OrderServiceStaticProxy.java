package pattern.proxy.dbrource.proxy;



import pattern.proxy.dbrource.db.DynamicDataSourceEntity;
import pattern.proxy.dbrource.service.IOrderService;
import pattern.proxy.dbrource.service.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tom on 2019/3/10.
 */
public class OrderServiceStaticProxy implements IOrderService {
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    public int createOrder(Order order) {
        Long time = order.getCreateTime();
        int dbRouter = Integer.parseInt(yearFormat.format(new Date(time)));
        DynamicDataSourceEntity.set(dbRouter);
        System.out.println("静态代理类自动分配到【DB_" +  dbRouter + "】数据源处理数据" );

        this.orderService.createOrder(order);
        DynamicDataSourceEntity.restore();

        return 0;
    }
}
