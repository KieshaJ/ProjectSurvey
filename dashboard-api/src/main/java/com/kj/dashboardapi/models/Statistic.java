package com.kj.dashboardapi.models;

import com.kj.dashboardapi.utils.models.IdEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Document
@Getter
@Setter
public class Statistic extends IdEntity {
    @NotNull
    private String surveyId;
    @NotEmpty
    private String question;
    private Map<String, Integer> answerCounts;

    public Statistic(ObjectId id, String surveyId, String question, Map<String, Integer> answerCounts) {
        super(id);
        this.surveyId = surveyId;
        this.question = question;
        this.answerCounts = answerCounts;
    }
}
