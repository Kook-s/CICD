package kr.handscope.interfaces.controller.measurement;

import kr.handscope.infra.gpt.service.GptService;
import kr.handscope.interfaces.dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/measurement")
public class MeasurementController {

    private final GptService gptService;

    @PostMapping("/question")
    public ResponseEntity<QuestionDto.Response> askQuestion(
            @RequestBody QuestionDto.Request request) {
        String answer = gptService.askQuestion(request.question());
        return ResponseEntity.ok(new QuestionDto.Response(answer));
    }
}