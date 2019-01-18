package net.luculent.automatioin.laks.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: caomingtao 接口文档
 * ## http://ip:port/v2/api-docs
 * ## http://ip:port/doc.html
 * @Description:
 * @Date Create In 9:13 2018/8/22
 * @Modified By:
 */

/**
 * ① @RequestMapping 中的方法要声明好为 get/post/put/delete，否则API文档有很多冗余
 * <p>
 * ② 建议使用 rest 风格，即使用 @GetMapping、@DeleteMapping、@PostMapping、@PutMapping 这4个取代笼统的 @RequestMapping
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Bean
    public Docket buildDocket() {

        //添加head参数 token
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();

        tokenPar.name("token").description("令牌 (非必填)")
                .modelRef(new ModelRef("string"))
                .parameterType("header").required(false).build();

        pars.add(tokenPar.build());


        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enableSwagger)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.luculent.automatioin.laks"))
                .build()
                .globalOperationParameters(pars)
                .apiInfo(buildApiInf());
    }

    private ApiInfo buildApiInf() {

        return new ApiInfoBuilder()
                .title("手机App")
                .description("手机App项目后端接口文档详情")
                .version("1.0")
                .contact("南京朗坤自动化有限公司")
                .termsOfServiceUrl("www.luculent-auto.com")
                .build();

    }
}
