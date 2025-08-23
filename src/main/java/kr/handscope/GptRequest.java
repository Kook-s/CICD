package kr.handscope;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record GptRequest(
        String model,
        List<Message> messages,
        Double temperature,
        @JsonProperty("max_completion_tokens")
        Integer maxCompletionTokens
) {

}