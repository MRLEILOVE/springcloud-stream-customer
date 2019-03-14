package com.leigq.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

/**
 * 自定义输入（RabbitMQ -> 程序，消费消息）通道
 * 写法可以参考 spring 自带 Sink 源码
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-13 17:27 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
public interface MyInputChannel {

    /*
    * 这里的名字需要和配置文件 bindings：下面的一致，不然会找不到这个通道
    * */
    String INPUT = "myInput";

    String INPUT2 = "myInput2";

    @Input(MyInputChannel.INPUT)
    SubscribableChannel input();

    @Input(MyInputChannel.INPUT2)
    SubscribableChannel input2();
}
