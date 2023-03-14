package gs.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Description swagger配置类
 * @Author gs
 * @Date 2021-10-25 20:35
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

    @Value("server.port")
    private String port;

    @Bean(value = "generalTemplate")
    public Docket generalTemplate() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("2.X版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("gs.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("student-manage")
                .description("学生管理")
                .termsOfServiceUrl("http://localhost:" + port + "/doc.html")
                .contact(new Contact("gs", "https://github.com/y369q369/springBoot-study/tree/master/general-template", "1486866853@qq.com"))
                .version("1.0")
                .build();
    }

}
