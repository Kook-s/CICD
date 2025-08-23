package kr.handscope;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GptService {

    private final WebClient webClient;

    @Value("${openai.api.url}")
    private String apiUrl;

    public GptService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String askQuestion(String question) {
        // prompt
        Message systemMessage = new Message("system", "Please always respond in Korean.");
        Message userMessage = new Message("user", question);

        GptRequest gptRequest = new GptRequest(
                "gpt-5-nano",   // gpt model
                List.of(systemMessage, userMessage),
                0.5,        // Accuracy ~ Creativity
                500
        );

        GptResponse gptResponse = webClient.post()
                                           .uri(apiUrl)
                                           .body(Mono.just(gptRequest), GptRequest.class)
                                           .retrieve()
                                           .bodyToMono(GptResponse.class)
                                           .block();

        return Optional.ofNullable(gptResponse)
                       .flatMap(GptResponse::getFirstMessageContent)
                       .orElse("답변 생성 실패");
    }
}