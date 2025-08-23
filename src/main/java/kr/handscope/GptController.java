package kr.handscope;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/gpt")
public class GptController {

    private final GptService gptService;

    public GptController(GptService gptService) {
        this.gptService = gptService;
    }

    @PostMapping("/question")
    public ResponseEntity<QuestionResponse> askQuestion(@RequestBody QuestionRequest request) {
        String answer = gptService.askQuestion(request.question());
        return ResponseEntity.ok(new QuestionResponse(answer));
    }
}