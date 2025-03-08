package com.study.integration.rest;


import java.util.List;

public record OpenAIResponse(List<Choice> choices) {}

record Choice(Message message) {}
