package com.deppon.mq.send;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.deppon.mq.client.MqContentDO;
import com.pamirs.mq.client.serialize.KryoSerializer;

/**
  * @Title mq 消息生产者
  * @author <a href="mailto:liulizheng@deppon.com">267452</a>
  * @version 1.0  
  * @date 2016年12月22日 下午1:53:58
 */
public class Producer {
	
	public static void main(String[] args){  
		MqContentDO mqDo = new MqContentDO();
		mqDo.setId("11111");
		mqDo.setContent("AAAAAAAAAAAAAAAAAAA");
        DefaultMQProducer producer = new DefaultMQProducer("Producer");
        producer.setNamesrvAddr("mq.deppon.namesrv:9876");
        producer.setProducerGroup("PRODUCER_GROUP");
        try {
            producer.start();
            Message msg = new Message("CONSUMER_TOPIC",
                    "CONSUMER_TAGS",
                    mqDo.getId(), 
                    new KryoSerializer<Object>().serialize(mqDo));
            SendResult result = producer.send(msg);
            
            System.out.println("id:" + result.getMsgId() +  
                    " result:" + result.getSendStatus());
       /*       
            msg = new Message("PushTopic",   
                    "push",   
                    "2",
                    "Just for test.".getBytes());  
              
            result = producer.send(msg);  
            System.out.println("id:" + result.getMsgId() +  
                    " result:" + result.getSendStatus());  
              
            msg = new Message("PullTopic",   
                    "pull",   
                    "1",   
                    "Just for test.".getBytes());  
              
            result = producer.send(msg);  */
        
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            producer.shutdown();  
        }  
    }  
}
