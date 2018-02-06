package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * use Eureka Server to get microService address [server port]
 *   --- client side load balancing
 */

@SpringBootApplication
@EnableEurekaServer  // mark this application as a eureka server application
public class EurekaApplication { // eureka server is a spring boot application
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
