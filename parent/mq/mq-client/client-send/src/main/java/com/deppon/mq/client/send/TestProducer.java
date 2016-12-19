package com.deppon.mq.client.send;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.deppon.mq.client.model.MqTradeDO;
import com.pamirs.mq.client.serialize.KryoSerializer;

/**
 * 测试生产者
 * @author <a href="mailto:yihui@alibaba-inc.com">yihui</a>
 * @version 1.0
 * @since 2015年6月3日
 */
public class TestProducer {
	
	public static void main(String[] args){  
		MqTradeDO mqDo = new MqTradeDO();
		mqDo.setNewHistoryId(1L);
		mqDo.setOldHistoryId(2L);
		String json = JSON.toJSONString(mqDo);
        DefaultMQProducer producer = new DefaultMQProducer("Producer");
        // producer.setNamesrvAddr("mq.deppon.namesrv:9876");
        
        producer.setNamesrvAddr("10.230.27.185:9876");
        try {
            producer.start();
            
        /*    Message msg = new Message("CUBC_TRADE_CORE_UPDATE",   
                    "CUBC_TRADE_UPDATE_VERIFY_AMOUNT",
                    "CUBC_TRADE_UPDATE_VERIFY_AMOUNT", 
                    json.getBytes());*/
              
            Message msg = new Message("CUBC_TRADE_CORE_UPDATE_1",   
                    "CUBC_TRADE_UPDATE_VERIFY_AMOUNT",
                    "CUBC_TRADE_UPDATE_VERIFY_AMOUNT", 
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
