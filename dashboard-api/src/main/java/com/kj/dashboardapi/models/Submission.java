package com.kj.dashboardapi.models;

import com.kj.dashboardapi.utils.models.IdEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Submission extends IdEntity {
    private String surveyId;
    private String userId;

    public Submission(ObjectId id, String surveyId, String userId) {
        super(id);
        this.surveyId = surveyId;
        this.userId = userId;
    }
}
