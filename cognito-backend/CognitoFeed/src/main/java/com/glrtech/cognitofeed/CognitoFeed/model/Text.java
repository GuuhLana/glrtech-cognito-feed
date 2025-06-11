package com.glrtech.cognitofeed.CognitoFeed.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "text")
public class Text {
	@Id
	private String id;
	private String title;
	private String content;
	private String source;
	private LocalDateTime createdAt = LocalDateTime.now();
}
