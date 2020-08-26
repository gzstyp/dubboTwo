
添加依赖,即引入服务发布者所在的api,通俗的就是一个jar文件,引入之后就到下面的引入dubbo服务;

引入dubbo服务,即spring-dubbo.xml配置待调用的服务接口,就是把上面的jar里所含有的服务配置在本文件spring-dubbo.xml;

调用服务生产者步骤：
第1步
引入生产服务方api的jar包
第2步
引入服务提供方提供的dubbo服务
含提供哪个服务名、url主机、协议、版本号、超时-->
    <dubbo:reference interface="com.debug.mooc.dubbo.one.api.service.IDubboItemService" id="iDubboItemService"
                     protocol="dubbo"
                     version="1.0"
                     timeout="20000" />


