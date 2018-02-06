package demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * webSocket configuration for Spring application
 */
@Configuration
@EnableWebSocketMessageBroker  // enables WebSocket message handling, backed by a message broker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // msg broker prefix [app.js]
        config.enableSimpleBroker("/topic/food"); // "topic"

        // prefix for messages that are bound for @MessageMapping-annotated methods.
        config.setApplicationDestinationPrefixes("/app");  // not use in this case
    }

    // for the 1st time webSocket connection
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // SockJS client [app.js] connect to this webSocket endpoint
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

}
