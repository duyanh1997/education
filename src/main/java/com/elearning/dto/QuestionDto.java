package com.elearning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private String content;
    private String selection1;
    private String selection2;
    private String selection3;
    private String selection4;

    private Integer answer;
    private Integer userChoice = -1;
}
