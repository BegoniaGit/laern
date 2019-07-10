package site.yanyan.learn.configer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig{


    @Bean
    public Docket sysDocket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("开发接口")
                .apiInfo(new ApiInfoBuilder().title("开发接口-接口文档")
                        .contact(new Contact("言言无绝期", "www.yanyan.site", "zhaoxubin2016@live.com")).version("1.0")
                        .build())
                .select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("site.yanyan.learn.controller.dev")).build()
                .globalOperationParameters(SwaggerConfig.getParamList());
    }

    @Bean
    public Docket manage() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("用户管理")
                .apiInfo(new ApiInfoBuilder().title("用户管理-接口文档")
                        .contact(new Contact("言言无绝期", "www.yanyan.site", "zhaoxubin2016@live.com")).version("1.0")
                        .build())
                .select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("site.yanyan.learn.controller.manage")).build()
                .globalOperationParameters(SwaggerConfig.getParamList());
    }









    static List<Parameter> getParamList() {
        List<Parameter> pars = new ArrayList<Parameter>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("token").description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();

        ParameterBuilder signPar = new ParameterBuilder();
        signPar.name("sign").description("数据签名")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        ParameterBuilder timePar = new ParameterBuilder();
        timePar.name("timestamp").description("时间戳")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();


        pars.add(tokenPar.build());
        pars.add(signPar.build());
        pars.add(timePar.build());
        return pars;
    }


//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("site.yanyan.learn.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Spring Boot中使用Swagger2构建RESTful API")
//                .description("rest api 文档构建利器")
//                .termsOfServiceUrl("http://blog.csdn.net/itguangit")
//                .contact("itguang")
//                .version("1.0")
//                .build();
//    }

}