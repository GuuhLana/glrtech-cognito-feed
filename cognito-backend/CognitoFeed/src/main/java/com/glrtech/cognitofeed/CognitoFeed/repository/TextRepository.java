package com.glrtech.cognitofeed.CognitoFeed.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.glrtech.cognitofeed.CognitoFeed.model.Text;

public interface TextRepository extends MongoRepository<Text, String>{

}
