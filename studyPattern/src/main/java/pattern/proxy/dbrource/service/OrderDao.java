package pattern.proxy.dbrource.service;

/**
 * @author 淘沙
 * @date 2020/08/23 2:16 下午
 */
public class OrderDao {

    int insert(Order order){
        System.out.println("Order创建成功");
        return 1;
    }
}
