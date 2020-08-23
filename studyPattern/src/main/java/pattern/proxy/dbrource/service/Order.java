package pattern.proxy.dbrource.service;

import lombok.Data;

/**
 * @author 淘沙
 * @date 2020/08/23 2:14 下午
 */
@Data
public class Order {
    private String id;
    private Long createTime;
    private Object orderInfo;
}
