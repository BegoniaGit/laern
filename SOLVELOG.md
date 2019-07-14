
# 开发过程的遇到的问题

### 跨域问题
由于浏览器的同源策略，前后端分离遇到的首要问题便是跨域。
1. 后端配置ResponseHeader：
```java
response.setHeader("Access-Control-Allow-Origin", "*");
```
2. 前端会OPTIONS预请求
```java
Access-Control-Request-Headers: authentication,content-type
```
所以后端应添加Access-Control-Allow-Headers,做到和OPTIONS请求相对应。
```java
response.setHeader("Access-Control-Allow-Headers", "content-type,authentication,dataType");
```

### Ajax请求回调/error
1. 一个Ajax请求
```javascript 1.8
 $.ajax({
            async: true,
            url: REMOTE_IP + path,
            headers: {
                "Content-Type": 'Application/json;charset=utf-8'
            },
            data: JSON.stringify(requestData),
            type: 'POST',
            success: fun
        });
```
2. 发起请求时data字段应写成字符串，即使数据为空也要写成JSON.stringify({}),否则Ajax请求会回调/error

### 配置拦截器
1. 首先需要过滤掉静态资源及相关接口文档
```java
@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecurityInterceptorConfig())
                //添加需要验证登录用户操作权限的请求
                .addPathPatterns("/**")
                //排除不需要验证登录用户操作权限的请求
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/swagger-ui/**");
    }
```




