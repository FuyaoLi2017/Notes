## Class Info

### full-stack & big data

### Microservice

### Customize the project description focusing on different projects

### System design
  - difficulties
  - trade offs

### coding ability

### First project: 协同编辑的OJ系统
Frontend
Node.js. Angular.js
Websocket, MongoDB
Docker(resource)

### Data pipeline
Kafka, Spark, Cassandra/HBase & MySQL
Data visulization
Mesos/Kubernetes

### High Performance Distributed System
system design trade-offs
database design/implementations  
MySQL: Master - slave 模式
压力测试

### Distributed Systems + Machine Learning
NLP, Spark MapReduce, Machine learning
web crawler， RPC

### First Project Content

#### HTML Basics
  - Tree Structure
  - CSS: style(inline, head, selector, responsive web design(boostrap))

#### JavaScript Basics
  - Object (key, value) tags
  - Function is a first-class object
  - Callback

#### Node.js
- JavaScript environment
- from chrome
- event driven method  
  eventEmitter -> Events -> Event Loop -> Event Handler
- Single thread non-blocking I/O / Multi thread
- 进程：约为不同的软件
- 线程：一个软件多个任务
- 了解多线程
- 分时做这些事情，轮转处理任务
- web server是多线程操作
- 多线程可以处理多个任务
- context switch看看之前处理的进度，这个需要成本,主要是进程的开销大。线程资源共享问题
- Thread pool: 管理线程，很大的开销
- CPU多个核心，分开处理的话还是单线程，处理多线程
- 多线程和单线程node.js差不多，nignx单线程大
- 网络通信，数据库，文件系统通信。blocking IO就只能等，可以将CPU交给处理IO的人。作为新的event加到尾部，有callback function, 回头去调用这个事件
- CPU intensive
