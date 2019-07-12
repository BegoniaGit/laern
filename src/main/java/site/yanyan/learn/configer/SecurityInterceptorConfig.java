package site.yanyan.learn.configer;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import site.yanyan.kit.Stamp;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Map;

import static javax.servlet.http.HttpServletResponse.SC_OK;


//安全拦截器配置
@Configuration
public class SecurityInterceptorConfig extends HandlerInterceptorAdapter {


    final Base64.Decoder decoder = Base64.getDecoder();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //设置响应头
        response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
        response.setHeader("server", "Linux");
        response.setContentType("Application/json;charset=utf-8");

        //排除处理相关url
        String[] excludeUrls = {"/secret/login"};

        String URL = request.getRequestURI();
        for (String u : excludeUrls)
            if(URL.equals(u))
                return true;

        //Token验证
        String token = request.getHeader("token");
        if (token == null || "".equals(token))
            return false;

        try {
            Algorithm algorithm = Algorithm.HMAC256("site.yanyan.wwww.secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("signingParty", "learn")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> info = jwt.getClaims();
            Stamp.log("token 验证通过");
            return true;

        } catch (JWTVerificationException exception) {
            Stamp.err("token 验证异常");
            response.setStatus(SC_OK);
            PrintWriter p= response.getWriter(); 
            p.println();
            p.println("{code:-1,msg:\"token验证错误\"}");
            p.close();

            return false;
        }

    }


}