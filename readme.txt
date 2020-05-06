host配置:
127.0.0.1  eurekaServer1.com eurekaServer2.com

启动顺序: 
1) cloud-eureka-server7001/cloud-eureka-server7002
2) cloud-provider-payment8001/cloud-provider-payment8002
3) consumer-order80

说明:
consumer-order80 中的 RestTemplate 的访问链接的域名url【payment.url】，其实就是 服务提供者 注册到 Eureka 的【spring.application.name】的全大写形式（我自己实践的是，这里大小写不敏感，可以随便写）。

