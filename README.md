# dx-boot-netty

> netty框架是一个主从Reactor多线程，这个地方理解不透彻
> bossGroup是负责接收请求，Reactor的核心在于一个线程可以处理多个请求，代码核心是for循环
> workGroup负责不同连接的读写请求，采用轮询，有数据到就开线程处理，没有数据就处理下一个；
> 只是分工明确，bossGroup负责连接，workGroup负责处理I/O请求；

## 编码的内容请单独学习

## netty核心
- Initiation Dispatcher 入口接收然后进行分发-> forech handle_event
    - Sync Event Demultiplexer : select（）根据结果进行分发让系统内核进行处理io事件
- Envent_Handler : get_handle() 进行处理已经就绪的事件

