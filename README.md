# dx-caht



## 编码的内容请单独学习

## IO模型
- BIO : block IO 同步阻塞IO
- NIO ： IO 同步非阻塞IO 
- AIO ： IO 异步非阻塞IO



## 大小端序

- 大端
  
  高数据位存在低地址的位置
  
- 小端

  高数据位存在高地址的位置

  如：md5

## 实时通讯

- ajax

- long pull

  和ajax差不多，发起一个请求后等待服务端返回数据才会发起一个新的请求，性能不好！！

- websock





## 到时候学习下protobuf





## netty

> netty框架是一个主从Reactor多线程，这个地方理解不透彻
> bossGroup是负责接收请求，Reactor的核心在于一个线程可以处理多个请求，代码核心是for循环
> workGroup负责不同连接的读写请求，采用轮询，有数据到就开线程处理，没有数据就处理下一个；
> 只是分工明确，bossGroup负责连接，workGroup负责处理I/O请求；

## netty核心

- Initiation Dispatcher 入口接收然后进行分发-> forech handle_event
  - Sync Event Demultiplexer : select（）根据结果进行分发让系统内核进行处理io事件
- Envent_Handler : get_handle() 进行处理已经就绪的事件

## netty支持的线程模型

- 单线程
- 多线程
- 主从线程组（官方推荐）



## TODO

futrure

