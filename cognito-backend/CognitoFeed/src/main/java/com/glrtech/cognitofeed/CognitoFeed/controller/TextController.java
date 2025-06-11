package com.glrtech.cognitofeed.CognitoFeed.controller;

import java.util.HashMap;
import java.util.List;

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

import com.glrtech.cognitofeed.CognitoFeed.model.Text;
import com.glrtech.cognitofeed.CognitoFeed.service.TextService;

@RestController
@RequestMapping("/api/text")
public class TextController {

	@Autowired
	private TextService service;
	
	@GetMapping("status")
	public ResponseEntity<HashMap<String, Object>> getApiStatus(){
		var response = new HashMap<String, Object>();
		
		response.put("service", "Text-API");
		response.put("status", "UP");
		response.put("httpStatus", HttpStatus.OK.value());
		
		return ResponseEntity.ok(response);
	}
	
    @GetMapping
    public List<Text> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Text findById(@PathVariable String id) {
        return service.findById(id).orElseThrow();
    }

    @PostMapping
    public Text create(@RequestBody Text texto) {
        return service.save(texto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
