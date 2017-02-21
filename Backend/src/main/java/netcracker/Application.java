package netcracker;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"netcracker"})
public class Application extends SpringBootServletInitializer {

    private static final Logger log = Logger.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {

        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure (log4jConfPath);

        log.info("Server start");
        SpringApplication.run(Application.class, args);
    }
}