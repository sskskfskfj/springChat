package spring.test.test;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;
import redis.embedded.RedisServerBuilder;


@Configuration
@Profile("local")
public class EmbeddedRedisConfig {

    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;

    @PostConstruct
    public void startRedisServer() throws Exception {
        System.out.println("port is " + redisPort);
        redisServer = new RedisServerBuilder()
                .port(redisPort)
                .build();
        redisServer.start();
    }

    @PreDestroy
    public void stopRedisServer() {
        if (redisServer != null) {
            redisServer.stop();
        }
    }
}

