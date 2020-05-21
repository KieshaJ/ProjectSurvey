package com.kj.dashboardapi.models;

import com.kj.dashboardapi.utils.models.IdEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document
public class Answer extends IdEntity {
    @NotEmpty
    private String answer;

    public Answer(ObjectId id, String answer) {
        super(id);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
