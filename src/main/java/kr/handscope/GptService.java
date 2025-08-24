package kr.handscope;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GptService {

    private final WebClient webClient;

    public GptService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String askQuestion(String question) {
        // prompt
        Message systemMessage = new Message("system", "Please always respond in Korean.");
        Message userMessage = new Message("user", question);

        GptRequest gptRequest = new GptRequest(
                "gpt-5-mini",   // gpt model
                List.of(systemMessage, userMessage)
        );

        GptResponse gptResponse = webClient.post()
                                           .bodyValue(gptRequest)
                                           .retrieve()
                                           .bodyToMono(GptResponse.class)
                                           .block();

        return Optional.ofNullable(gptResponse)
                       .flatMap(GptResponse::getFirstMessageContent)
                       .filter(a -> !a.isEmpty())
                       .orElse("답변 생성 실패");
    }
}