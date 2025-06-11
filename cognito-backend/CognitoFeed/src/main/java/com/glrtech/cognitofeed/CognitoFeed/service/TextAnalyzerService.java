package com.glrtech.cognitofeed.CognitoFeed.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.glrtech.cognitofeed.CognitoFeed.dto.AnswerAnalyzeDTO;

@Service
public class TextAnalyzerService {

    private static final Logger logger = LoggerFactory.getLogger(TextAnalyzerService.class);

    @Autowired
    private RestTemplate restTemplate;

    private static final String IA_API_URL = "http://localhost:8000/analyze";

    public AnswerAnalyzeDTO textAnalyzer(String text) {
        logger.info("Sending text to NLP API for analysis...");

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("text", text);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<AnswerAnalyzeDTO> response = restTemplate.postForEntity(
                IA_API_URL, request, AnswerAnalyzeDTO.class
            );
            logger.info("NLP API response received successfully.");
            return response.getBody();
        } catch (Exception e) {
            logger.error("Error while calling NLP service: {}", e.getMessage());
            throw new RuntimeException("Failed to communicate with NLP service", e);
        }
    }
}