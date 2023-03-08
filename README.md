# takeout_proj
[参考视频](https://www.bilibili.com/video/BV13a411q753)

基本上是对着课程复现的一个项目。该文档随着时间逐步更新，（简单敲点我自己的理解）

## day1
新装了MySQL，修了一下原本的maven环境，根据教程完成了后端初步的登录登出功能。

## day2
（摸了亿点点，只完成了完善登录功能的部分）

暂且加了一个全局exception的处理器，处理了用户名重复的错误，其他错误暂定。

## day3
（我也是加把劲骑士）

写了更新员工状态，但是一步步来实现的过程中，发现前端传回的id因Long原因丢失精度（id19位而long最多处理16位，剩下的四舍五入了），进而追加`JacksonObjectMapper`来进行相应的转换。

同时，继承原本已有的消息转换器，我们在`WebMvcConfig`里面扩展一个新的转换器来转换消息，将java对象打包成json。

配置`WebMvcConfig`的时候遇到了加载不到静态资源的bug，解决方案是`extends WebMvcConfigurationSupport`改成`implements WebMvcConfigurer`，同时内部的方法改成public。

虽然我也是冈巴拉奈特（x）但是今天已经12：30了，要day4力但是还在day3的视频，开摆！

## day4
对所有table里的数据所共有的字段（公共字段）进行了自动填充处理，避免代码出现过多重复的语句。

在`MyMetaObjecthandler`里实现（implements）了`MetaObjectHandler`来完成的，重写了insert和update两种方法。

由于在当前类里面不能动态的直接获取到用户的id等信息（这些信息存在于HttpSession里），因此我们使用`ThreadLocal`来解决此问题。

`ThreadLocal`会为每个使用它所维护的变量的线程提供独立的一个该变量的副本，该变量副本可以修改，在线程内可访问，线程外不可访问，进行了一个线程隔离。

测试可知`LoginCheckFilter`,`Employee Controller`和`MyMetaObjecthandler`在一次请求中会在一个线程内先后进行调用，因此我们考虑在`LoginCheckFilter`记录下（set）用户的id，然后在`MyMetaObjecthandler`来获取到（get）用户的id。

经测试后通过，公共字段自动填充完成。

新增分类功能开始实现。

完成了新增分类，删除分类和修改分类。

但是，这才day3刚结束，但是已经11点了，但是但是但是但是但是（x精神状态欠佳）

今天就这样吧，开摆！

## day5

