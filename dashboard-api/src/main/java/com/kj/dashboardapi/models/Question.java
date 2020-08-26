package com.kj.dashboardapi.models;

import com.kj.dashboardapi.utils.enums.QuestionType;
import com.kj.dashboardapi.utils.models.IdEntity;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document
@Getter
@Setter
public class Question extends IdEntity {
    @NotEmpty
    private String question;
    private String description;
    @NotNull
    private QuestionType questionType;
    @NotNull
    private Boolean required;
    @DBRef
    private List<Answer> answerList;

    public Question(ObjectId id, String question, String description, QuestionType questionType, Boolean required, List<Answer> answerList) {
        super(id);
        this.question = question;
        this.description = description;
        this.questionType = questionType;
        this.required = required;
        this.answerList = answerList;
    }
}
