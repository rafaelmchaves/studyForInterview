package com.study.integration.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OpenAiIntegration {

    private final WebClient webClient;

    @Value("${spring.ai.openai.api-key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    public OpenAiIntegration(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<String> getChatResponse(String userMessage) {
        final var message = "I want that you create a small list of questions and answers about: " + userMessage;
        OpenAIRequest request = new OpenAIRequest(
                "gpt-3.5-turbo",
                List.of(new Message("user", message)),
                0.1
        );

        return webClient.post()
                .uri(apiUrl)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(OpenAIResponse.class)
                .map(response -> response.choices().get(0).message().content());
    }
}
