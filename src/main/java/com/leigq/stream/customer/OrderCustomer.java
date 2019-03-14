package com.leigq.stream.customer;

import com.leigq.stream.channel.MyInputChannel;
import com.leigq.stream.entity.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * Stream 实现消息接受者(接受订单消息)
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-13 17:13 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Slf4j
// 这里可以开启多个通道绑定
@EnableBinding({Sink.class, MyInputChannel.class})
public class OrderCustomer {

    /**
     * spring 自带输入通道测试
     * <br>创建人： leiGQ
     * <br>创建时间： 2019-03-13 17:30
     * <p>
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     * <br>
     */
    @StreamListener(Sink.INPUT)
    public void processOrder1(OrderMaster orderMaster) {
        log.warn("接受到了订单.....");
        log.warn("processOrder1:{}", orderMaster);
    }

    /**
     * 自定义输入通道测试
     * <br>创建人： leiGQ
     * <br>创建时间： 2019-03-13 17:31
     * <p>
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     * <br>
     */
    @StreamListener(MyInputChannel.INPUT)
    @SendTo(MyInputChannel.INPUT2) // 将消息转发给 INPUT2 输入通道, 下面那个方法
    public OrderMaster processOrder2(OrderMaster orderMaster) {
        log.warn("接受到了订单.....");
        log.warn("processOrder2:{}", orderMaster);
        // 将 orderMaster 发送到 INPUT2
        return orderMaster;
    }

    @StreamListener(MyInputChannel.INPUT2)
    public void processOrder3(OrderMaster orderMaster) {
        // 接收 orderMaster
        log.warn("接受到了消息转发，orderMaster：{}", orderMaster);
    }


}
