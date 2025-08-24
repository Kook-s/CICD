package kr.handscope;

import java.util.List;

public record GptRequest(
        String model,
        List<Message> messages
) {

}