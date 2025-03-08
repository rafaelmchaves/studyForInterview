package com.study.integration.rest;

import java.util.List;

public record OpenAIRequest(String model, List<Message> messages, double temperature) {}

record Message(String role, String content) {}

