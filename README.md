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


