package com.deppon.mq.metaq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deppon.mq.client.MqContentDO;
import com.pamirs.mq.client.IMqConsumer;
import com.pamirs.mq.client.domain.MonoMqResultDTO;
import com.pamirs.mq.client.exception.MonoMqException;

/**
  * @Title 接收消息
  * @author <a href="mailto:liulizheng@deppon.com">267452</a>
  * @version 1.0  
  * @date 2016年12月22日 上午11:42:18
 */
public class Consumer  implements IMqConsumer<MqContentDO> {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	public MonoMqResultDTO consume(MqContentDO mqContentDO)
			throws MonoMqException {
		//TODO 重复消息校验
		MonoMqResultDTO monoMqResultDTO = new MonoMqResultDTO();
		if(mqContentDO==null || mqContentDO.getContent() == null ){
			logger.error("consume error： 参数不存在");
            monoMqResultDTO.setErrorCode("consume error： 参数不存在");
            //消息重发
            monoMqResultDTO.setNeedRedo(true);
            return monoMqResultDTO;
		}
		
		System.out.println("receive mq content:"+mqContentDO.getContent());

		return monoMqResultDTO;
	}
	
}
