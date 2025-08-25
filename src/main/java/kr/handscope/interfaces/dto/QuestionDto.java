package kr.handscope.interfaces.dto;

public class QuestionDto {

    public record Request(
            String question
    ) {

        public Request {
            // validation
        }
    }

    public record Response(
            String answer
    ) {

    }

}
