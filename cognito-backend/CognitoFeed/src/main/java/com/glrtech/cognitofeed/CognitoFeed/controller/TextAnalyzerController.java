package com.glrtech.cognitofeed.CognitoFeed.controller;

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
    @Autowired
    private TextService textService;

    @Autowired
    private TextAnalyzerService analyzerService;

    @GetMapping("/{id}")
    public ResponseEntity<AnswerAnalyzeDTO> textAnalyzer(@PathVariable String id) {
        Text text = textService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        AnswerAnalyzeDTO answer = analyzerService.textAnalyzer(text.getContent());
        return ResponseEntity.ok(answer);
    }
}
