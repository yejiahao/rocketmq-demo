package cn.yejh.rocketmq.rocketmqdemo.listener;

import cn.yejh.rocketmq.rocketmqdemo.common.RocketConstant;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:yejh.1248@qq.com">Ye Jiahao</a>
 * @create 2020-07-07
 * @since x.y.z
 */
@Service
@RocketMQMessageListener(topic = RocketConstant.ROCKET_TOPIC, consumerGroup = RocketConstant.ROCKET_CONSUMER_GROUP)
public class PraiseListener implements RocketMQListener<Integer>, RocketMQPushConsumerLifecycleListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(PraiseListener.class);

    @Override
    public void onMessage(Integer message) {
        LOGGER.info("Message: [{}]", message);
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        // 每次拉取的间隔
        consumer.setPullInterval(3000L);
        // 设置每次从队列中拉取的消息数
        consumer.setPullBatchSize(8);

    }
}
