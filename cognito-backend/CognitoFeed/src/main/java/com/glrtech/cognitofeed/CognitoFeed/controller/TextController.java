package com.glrtech.cognitofeed.CognitoFeed.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.glrtech.cognitofeed.CognitoFeed.model.Text;
import com.glrtech.cognitofeed.CognitoFeed.service.TextService;

@RestController
@RequestMapping("/api/text")
public class TextController {

    private static final Logger logger = LoggerFactory.getLogger(TextController.class);

    @Autowired
    private TextService service;

    @GetMapping("status")
    public ResponseEntity<HashMap<String, Object>> getApiStatus() {
        logger.debug("Checking API status...");
        var response = new HashMap<String, Object>();
        response.put("service", "Text-API");
        response.put("status", "UP");
        response.put("httpStatus", HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<Text> list() {
        logger.info("Fetching all texts from the database...");
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Text findById(@PathVariable String id) {
        logger.info("Fetching text by ID: {}", id);
        return service.findById(id).orElseThrow(() -> {
            logger.warn("Text not found with ID: {}", id);
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    @PostMapping
    public Text create(@RequestBody Text texto) {
        logger.info("Creating new text: {}", texto.getTitle());
        return service.save(texto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        logger.info("Deleting text with ID: {}", id);
        service.delete(id);
    }
}

