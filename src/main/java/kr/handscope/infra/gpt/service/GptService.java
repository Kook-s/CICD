package kr.handscope.infra.gpt.service;

import java.util.List;
import java.util.Optional;
import kr.handscope.infra.gpt.Gpt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class GptService {

    private final WebClient webClient;

    public String askQuestion(String question) {
        // prompt
        Gpt.Message systemMessage = new Gpt.Message("system", "Please always respond in Korean.");
        Gpt.Message userMessage = new Gpt.Message("user", question);

        Gpt.Request gptRequest = new Gpt.Request(
                "gpt-5-mini",   // gpt model
                List.of(systemMessage, userMessage)
        );

        Gpt.Response gptResponse = webClient.post()
                                            .bodyValue(gptRequest)
                                            .retrieve()
                                            .bodyToMono(Gpt.Response.class)
                                            .block();

        return Optional.ofNullable(gptResponse)
                       .flatMap(Gpt.Response::getFirstMessageContent)
                       .filter(a -> !a.isEmpty())
                       .orElse("답변 생성 실패");
    }
}