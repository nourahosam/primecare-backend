package clinic.recordmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "clinic.recordmanagement.*")
@ComponentScan(basePackages = {"clinic.recordmanagement.*"})
@EntityScan(basePackages = {"clinic.recordmanagement.*"})
@EnableJpaRepositories(basePackages = {"clinic.recordmanagement.*"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
