package kr.handscope;

import java.util.List;
import java.util.Optional;

public record GptResponse(
        List<Choice> choices
) {

    public record Choice(
            Message message
    ) {

    }

    public Optional<String> getFirstMessageContent() {
        return Optional.ofNullable(choices)
                       .filter(c -> !c.isEmpty())
                       .map(c -> c.get(0))
                       .map(Choice::message)
                       .map(Message::content);
    }
}
