package spring.test.test;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;

@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
   @Override
   public void configureMessageBroker(MessageBrokerRegistry config){
       config.enableSimpleBroker("/sub");
       config.setApplicationDestinationPrefixes("/pub");
   }
   @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
       registry.addEndpoint("/ws-stomp").setAllowedOriginPatterns("https://*.example.com").withSockJS();

   }


}
