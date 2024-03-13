package clinic.recordmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "clinic.*")
@ComponentScan(basePackages = {"clinic.*"})
@EntityScan(basePackages = {"clinic.*"})
@EnableJpaRepositories(basePackages = {"clinic.*"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
