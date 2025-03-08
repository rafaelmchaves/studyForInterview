package com.study.integration.controller;

import com.study.integration.rest.OpenAiIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/interview-questions")
public class StudyController {

    private final OpenAiIntegration openAiIntegration;

    @GetMapping
    public ResponseEntity<InterviewQuestionResponse> searchStudyOpenAi(@RequestParam String query) {
        final var response = openAiIntegration.getChatResponse(query);
        var interviewQuestion = InterviewQuestionResponse.builder().response(response.block()).build();
        return ResponseEntity.ok(interviewQuestion);

    }

//    @GetMapping(""\\)
//    public ResponseEntity<Void> test() {
//        return ResponseEntity.ok().build();
//    }
}
