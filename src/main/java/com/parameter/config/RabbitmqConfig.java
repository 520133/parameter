package com.parameter.config;

import com.parameter.util.mq.ConfirmCallbackService;
import com.parameter.util.mq.ReturnCallbackService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class RabbitmqConfig {

    @Autowired
    private ConfirmCallbackService confirmCallbackService;

    @Autowired
    private ReturnCallbackService returnCallbackService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue confirmTestQueue() {
        return new Queue("confirm_test_queue", true, false, false);
    }

    @Bean
    public FanoutExchange confirmTestExchange() {
        return new FanoutExchange("confirmTestExchange");
    }

    @Bean
    public Binding confirmTestFanoutExchangeAndQueue(
            @Qualifier("confirmTestExchange") FanoutExchange confirmTestExchange,
            @Qualifier("confirmTestQueue") Queue confirmTestQueue) {
        return BindingBuilder.bind(confirmTestQueue).to(confirmTestExchange);
    }



    @PostConstruct
    public void initRabbitTemplate(){
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(confirmCallbackService);
        rabbitTemplate.setReturnCallback(returnCallbackService);
    }
}
