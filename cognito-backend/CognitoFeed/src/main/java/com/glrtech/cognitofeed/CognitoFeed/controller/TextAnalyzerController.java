package com.glrtech.cognitofeed.CognitoFeed.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.glrtech.cognitofeed.CognitoFeed.dto.AnswerAnalyzeDTO;
import com.glrtech.cognitofeed.CognitoFeed.model.Text;
import com.glrtech.cognitofeed.CognitoFeed.service.TextAnalyzerService;
import com.glrtech.cognitofeed.CognitoFeed.service.TextService;

@RestController
@RequestMapping("/api/analyzer")
public class TextAnalyzerController {

    private static final Logger logger = LoggerFactory.getLogger(TextAnalyzerController.class);

    @Autowired
    private TextService textService;

    @Autowired
    private TextAnalyzerService analyzerService;

    @GetMapping("/{id}")
    public ResponseEntity<AnswerAnalyzeDTO> textAnalyzer(@PathVariable String id) {
        logger.info("Starting analysis for text with ID: {}", id);

        Text text = textService.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Text not found with ID: {}", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND);
                });

        logger.info("Text found. Sending content to NLP service...");
        AnswerAnalyzeDTO answer = analyzerService.textAnalyzer(text.getContent());

        logger.info("Analysis successfully completed for text ID: {}", id);
        return ResponseEntity.ok(answer);
    }
}
