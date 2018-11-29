### Springboot Project
http://www.cnblogs.com/tuhooo/p/9207209.html
Create stand-alone Spring applications

Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files)

Provide opinionated 'starter' dependencies to simplify your build configuration

Automatically configure Spring and 3rd party libraries whenever possible

Provide production-ready features such as metrics, health checks and externalized configuration

Absolutely no code generation and no requirement for XML configuration

https://www.jb51.net/article/134578.htm

#### HTTP 401 问题
https://blog.csdn.net/jhk2026126055/article/details/80490051

### HATEOAS使用
https://www.ibm.com/developerworks/cn/java/j-lo-SpringHATEOAS/index.html

### infinite loop
之前多写了一个元素，造成了未知的循环，但是可以通过增加注解解决
For Jackson to work well, one of the two sides of the relationship should not be serialized, in order to avoid the annoying infinite recursive loop that causes our stackoverflow error.

So, Jackson takes the forward part of the reference, for example an attribute of a java class (i.e. List<Role> roles in User class), and converts it in a json-like storage format; this is the so-called marshalling process.
Then, Jackson looks for the back part of the reference (i.e. List<User> users in Role class) and leaves it as it is, not serializing it. This part of the relationship will be re-constructed during the deserialization (unmarshalling) of the forward reference.
http://keenformatics.blogspot.com/2013/08/how-to-solve-json-infinite-recursion.html
