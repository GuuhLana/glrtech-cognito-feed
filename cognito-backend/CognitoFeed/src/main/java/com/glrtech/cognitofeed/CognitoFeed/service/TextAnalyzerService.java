package com.glrtech.cognitofeed.CognitoFeed.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.glrtech.cognitofeed.CognitoFeed.dto.AnswerAnalyzeDTO;

@Service
public class TextAnalyzerService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String IA_API_URL = "http://localhost:8000/analyze";

	public AnswerAnalyzeDTO textAnalyzer(String text) {
		// Correção: usar HashMap explicitamente para evitar inferência problemática
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("text", text);

		// Correção: headers corretamente instanciado
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Map<String, String>> request = new HttpEntity<>(requestBody, headers);

		ResponseEntity<AnswerAnalyzeDTO> response = restTemplate.postForEntity(IA_API_URL, request,
				AnswerAnalyzeDTO.class);

		return response.getBody();
	}
}
