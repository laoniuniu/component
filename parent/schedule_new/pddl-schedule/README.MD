项目工程说明：
trade-client:                   api定义、model对象、常量等 
trade-core:                 	service、manager、dao
trade-esb:                    	esb接口和实现                  
trade-web:                      启动工程，以及后台管理页面
trade-mq:			消息
trade-sync:			同步表


开发环境域名绑定：
10.230.27.185 zk.api.deppon.com
10.230.27.185 mq.deppon.namesrv
10.230.27.185 mq.deppon.broker01
10.230.27.185 mq.deppon.broker02
10.230.27.193 env.pddl.deppon.com


启动工程时，在${user.home}目录下，添加 ".trade_config" 以英文句号开头的隐藏文件，添加如下配置：

# dubbo
dubbo.container=log4j,spring
dubbo.application.name=cubc-trade
dubbo.application.owner=cubc-trade
dubbo.registry.address=zookeeper://zk.api.deppon.com:2181
dubbo.protocol.name=dubbo
dubbo.protocol.port=17200
dubbo.service.loadbalance=roundrobin
dubbo.consumer.check=false
dubbo.consumer.timeout=5000
dubbo.provider.timeout=5000
dubbo.dubbo_env=local

# schedule
zk.schedule.address=zk.api.deppon.com:2181
zk.schedule.rootPath=/schedule/cubc/trade
zk.schedule.zkSessionTimeout=60000
zk.schedule.userName=ScheduleAdmin
zk.schedule.password=password
zk.schedule.isCheckParentPath=true
schedule.cubc.trade.ownSign=local

# 普通任务schedule truncate 开发环境配置
schedule.truncate.database.address=10.230.27.193
schedule.truncate.database.port=3306
schedule.truncate.database.name=cubc_trade_normal
schedule.truncate.database.username=admin
schedule.truncate.database.password=deppon@Deppon123!

# 结算事件日志schedule truncate
schedule.trade.truncate.database.address0=10.230.27.193
schedule.trade.truncate.database.port0=3306
schedule.trade.truncate.database.name0=cubc_trade_00
schedule.trade.truncate.database.username0=admin
schedule.trade.truncate.database.password0=deppon@Deppon123!
schedule.trade.truncate.database.address1=10.230.27.193
schedule.trade.truncate.database.port1=3306
schedule.trade.truncate.database.name1=cubc_trade_01
schedule.trade.truncate.database.username1=admin
schedule.trade.truncate.database.password1=deppon@Deppon123!
schedule.trade.truncate.database.address2=10.230.27.193
schedule.trade.truncate.database.port2=3306
schedule.trade.truncate.database.name2=cubc_trade_02
schedule.trade.truncate.database.username2=admin
schedule.trade.truncate.database.password2=deppon@Deppon123!
schedule.trade.truncate.database.address3=10.230.27.193
schedule.trade.truncate.database.port3=3306
schedule.trade.truncate.database.name3=cubc_trade_03
schedule.trade.truncate.database.username3=admin
schedule.trade.truncate.database.password3=deppon@Deppon123!
schedule.trade.truncate.database.address4=10.230.27.193
schedule.trade.truncate.database.port4=3306
schedule.trade.truncate.database.name4=cubc_trade_04
schedule.trade.truncate.database.username4=admin
schedule.trade.truncate.database.password4=deppon@Deppon123!
schedule.trade.truncate.database.address5=10.230.27.193
schedule.trade.truncate.database.port5=3306
schedule.trade.truncate.database.name5=cubc_trade_05
schedule.trade.truncate.database.username5=admin
schedule.trade.truncate.database.password5=deppon@Deppon123!
schedule.trade.truncate.database.address6=10.230.27.193
schedule.trade.truncate.database.port6=3306
schedule.trade.truncate.database.name6=cubc_trade_06
schedule.trade.truncate.database.username6=admin
schedule.trade.truncate.database.password6=deppon@Deppon123!
schedule.trade.truncate.database.address7=10.230.27.193
schedule.trade.truncate.database.port7=3306
schedule.trade.truncate.database.name7=cubc_trade_07
schedule.trade.truncate.database.username7=admin
schedule.trade.truncate.database.password7=deppon@Deppon123!


# pddl
pddl.cubc.trade.appName=CUBC-TRADE
pddl.cubc.pretrade.appName=CUBC-PRETRADE
pddl.cubc.trade.normal.appName=CUBC-TRADE-NORMAL
pddl.cubc.trade.base.appName=CUBC-TRADE-BASE
pddl.cubc.trade.user.appName=CUBC-TRADE-USER
pddl.cubc.trade.user.backup.appName=CUBC-TRADE-USER-BACKUP

# canal
# 单个地址配置
zk.canal.address=zk.api.deppon.com:2181
# 多个地址配置 分号分隔
# zk.canal.address=zk1.api.deppon.com:2181;zk2.api.deppon.com:2181
