# SpringBoot整合Dubbo
### 微服务面临的四个问题
1. 这么多服务客户端如何访问(API网关)
2. 服务与服务之间如何通信(rpc/http)
3. 多服务如何管理（zk/redis...）
4. 服务挂了怎么办（熔断）
### 分支管理
1. master 主分支为最终案例项目
2. feature/1.1 分支为最简单的入门案例
3. feature/1.2 使用kryo实现高速序列化
4. feature/1.3 dubbo+hystrix 实现服务熔断
5. feature/1.4 多版本，本地存根，dubo直连
### kyro序列化
1. 添加kyro依赖
2. 添加配置
4. 注意事项：
    - 被序列化的类应当实现java.io.Serializable接口
    - 提供无参构造方法
    - 底层会透明的将Java的原生序列化替换成kyro序列化
 
### 使用Hystrix实现服务熔断
1. 服务提供者和消费者添加依赖
2. 在需用开启熔断提供者方法上添加@HystrixCommand
3. 服务消费者的调用方法上添加@HystrixCommand(fallbackMethod = "fallbackMethod"),并配置熔断方法
4. 服务提供者和服务消费者启动类添加@EnableHystrix开启熔断

### 多版本
1. 提供者指定方法的版本号
2. 消费者在调用时指定调用的版本

### 本地存根
1. 在本地提供实现同样接口的代理类
2. 用构造器注入dubbo服务
3. 在代理类内可以更具情况调用远程方法
4. 在@Reference注解上配置stub属性(代理类的全限定名)

### dubbo直连
1. 通过@Reference注解的url属性指定服务地址，可直接找到对应主机的远程服务，而不用再找注册中心
2. url配置为 ip:port
 
 ### 负载均衡
 - 负载均衡策略
    1. RandomLoadBalance 随机调用
    2. RoundRobinLoadBlance 轮询调用
    3. LeastActiveLoadBlance 最少活跃数调用
    4. ConsistentHashLoadBalance 一致性Hash
 - 在@Reference配置loadbalance属性
 
### 启动步骤
1. 先启动zookeeper
2. 启动服务提供者
3. 启动消费者

### dubbo-admin
dubbo的监控管理平台

- 同样需要zk的支持
- jar 包在dubboparent/resources/dubbo-admin目录下
- java -jar运行即可，启动端口7001
