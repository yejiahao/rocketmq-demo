package cn.yejh.rocketmq.rocketmqdemo.controller;

import cn.yejh.rocketmq.rocketmqdemo.common.RocketConstant;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:yejh.1248@qq.com">Ye Jiahao</a>
 * @create 2020-07-07
 * @since x.y.z
 */
@RestController
public class MessageController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    private AtomicInteger cnt = new AtomicInteger(100);

    @GetMapping("/praise")
    public int praise() {
        rocketMQTemplate.sendOneWay(RocketConstant.ROCKET_TOPIC, MessageBuilder.withPayload(cnt.incrementAndGet()).build());
        return cnt.get();
    }
}
