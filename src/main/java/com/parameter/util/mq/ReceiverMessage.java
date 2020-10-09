package com.parameter.util.mq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author 杨森霖
 * @author 2020/10/9 0009 上午 10:52
 */

@Slf4j
@Component
public class ReceiverMessage {

    @RabbitHandler
    @RabbitListener(queues = "confirm_test_queue")
    public void processHandler(String msg, Channel channel, Message message) throws IOException {
        try {
            log.info("收到消息：{}", msg);

            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            // 第一个参数:message.getMessageProperties().getDeliveryTag()  消息投递的序号
            // 第二个参数:是否批量确认，值为 true 则会一次性 ack所有小于当前消息 deliveryTag 的消息
            // 第三个参数，值为true时重新进入队列
        }catch (Exception e){
            if (message.getMessageProperties().getRedelivered()) {
                //当两次都失败后做异常处理，将该消息持久化，发送邮箱到指定账户通知
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false); // 拒绝消息
            } else {
                log.error("消息即将再次返回队列处理...");
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
        System.out.println(msg);
    }

}
