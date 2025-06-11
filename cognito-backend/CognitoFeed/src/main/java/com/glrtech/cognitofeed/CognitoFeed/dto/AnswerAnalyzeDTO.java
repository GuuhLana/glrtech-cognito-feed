package com.glrtech.cognitofeed.CognitoFeed.dto;

import lombok.Data;

@Data
public class AnswerAnalyzeDTO {

    private String summary;
    private String sentiment;
    private double confidence;
}
