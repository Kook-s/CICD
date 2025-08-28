package kr.handscope.support.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${OPENAI_API_KEY}")
    private String apiKey;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                        .baseUrl("https://api.openai.com/v1/chat/completions")
                        .defaultHeader("Authorization", "Bearer " + apiKey)
                        .defaultHeader("Content-Type", "application/json")
                        .build();
    }
}