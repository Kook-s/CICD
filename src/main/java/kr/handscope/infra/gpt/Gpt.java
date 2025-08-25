package kr.handscope.infra.gpt;

import java.util.List;
import java.util.Optional;

public class Gpt {

    public record Request(
            String model,
            List<Message> messages
    ) {

    }

    public record Response(
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

    public record Message(
            String role,
            String content
    ) {

    }

}
