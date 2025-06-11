package com.glrtech.cognitofeed.CognitoFeed.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glrtech.cognitofeed.CognitoFeed.model.Text;
import com.glrtech.cognitofeed.CognitoFeed.repository.TextRepository;

@Service
public class TextService {

    private static final Logger logger = LoggerFactory.getLogger(TextService.class);

    @Autowired
    private TextRepository repository;

    public Text save(Text text) {
        logger.info("Saving new text: {}", text.getTitle());
        return repository.save(text);
    }

    public List<Text> listAll() {
        logger.debug("Retrieving all texts from database...");
        return repository.findAll();
    }

    public Optional<Text> findById(String id) {
        logger.debug("Looking for text with ID: {}", id);
        return repository.findById(id);
    }

    public void delete(String id) {
        logger.info("Deleting text with ID: {}", id);
        repository.deleteById(id);
    }
}