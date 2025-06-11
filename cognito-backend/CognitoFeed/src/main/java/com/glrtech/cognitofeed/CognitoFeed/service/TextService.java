package com.glrtech.cognitofeed.CognitoFeed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glrtech.cognitofeed.CognitoFeed.model.Text;
import com.glrtech.cognitofeed.CognitoFeed.repository.TextRepository;

@Service
public class TextService {

	@Autowired
	private TextRepository repository;
	
	public Text save(Text text) {
		return repository.save(text);
	}
	
    public List<Text> listAll() {
        return repository.findAll();
    }

    public Optional<Text> findById(String id) {
        return repository.findById(id);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
