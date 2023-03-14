package gs.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
@MapperScan({"gs.demo.mapper"})
public class StudentManageApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(StudentManageApplication.class, args);
        Environment env = application.getEnvironment();
        String applicationName = "";
        String contextPath = env.getProperty("server.servlet.context-path");
        if (contextPath == null) {
            contextPath = "";
        } else {
            applicationName = contextPath.substring(1);
        }
        String address = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String external = "http://" + address + ":" + port + contextPath;
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application {} is running! Access URLs: \n\t" +
                        "External: \t {} \n\t"+
                        "Doc: \t\t {}/doc.html \n"+
                        "----------------------------------------------------------",
                applicationName,
                external,
                external);
    }

}
