package site.yanyan.learn.configer;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.yanyan.kit.Stamp;

import javax.servlet.*;
import java.io.IOException;

//@Configuration
public class ResponsetBaseConfig {

//    @Bean
//    public FilterRegistrationBean responsetBaseConfig() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new Filter() {
//            @Override
//            public void init(FilterConfig filterConfig) throws ServletException {
//
//            }
//
//            @Override
//            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//                Stamp.log("执行到了过滤器");
//
//            }
//
//            @Override
//            public void destroy() {
//
//            }
//        });
//        registration.addUrlPatterns("/**");
//        registration.setName("responsetBaseConfig");
//        registration.setOrder(1);
//        return registration;
//    }


}


