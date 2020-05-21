package com.kj.dashboardapi.models;

import com.kj.dashboardapi.utils.enums.SurveyStatus;
import com.kj.dashboardapi.utils.models.IdEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document
@Getter
@Setter
public class Survey extends IdEntity {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotNull
    private SurveyStatus status;
    @DBRef
    @Min(1)
    private List<Question> questionList;

    public Survey(ObjectId id, String name, String description, SurveyStatus status, List<Question> questionList) {
        super(id);
        this.name = name;
        this.description = description;
        this.status = status;
        this.questionList = questionList;
    }
}
