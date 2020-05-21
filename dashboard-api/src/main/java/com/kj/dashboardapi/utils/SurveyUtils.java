package com.kj.dashboardapi.utils;

import com.kj.dashboardapi.models.Answer;
import com.kj.dashboardapi.models.Question;
import com.kj.dashboardapi.models.Survey;
import com.kj.dashboardapi.repositories.AnswerRepository;
import com.kj.dashboardapi.repositories.QuestionRepository;
import com.kj.dashboardapi.repositories.SurveyRepository;
import com.kj.dashboardapi.utils.filters.SurveyFilter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SurveyUtils {
    public static Query queryFromFilter(SurveyFilter filter) {
        Query query = new Query();

        if(filter.getName() != null && !filter.getName().isEmpty()) {
            query.addCriteria(Criteria.where("name").is(filter.getName()));
        }
        if(filter.getStatus() != null) {
            query.addCriteria(Criteria.where("status").is(filter.getStatus()));
        }

        return query;
    }

    public static List<Question> saveQuestions(List<Question> questionList, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        return questionRepository.saveAll(questionList.stream().peek(question -> {
            List<Answer> savedAnswers = saveAnswers(question.getAnswerList(), answerRepository);
            question.setAnswerList(savedAnswers);
        }).collect(Collectors.toList()));
    }

    public static List<Answer> saveAnswers(List<Answer> answerList, AnswerRepository repository) {
        return repository.saveAll(answerList);
    }

    public static Survey findSurvey(String id, SurveyRepository repository) throws Exception {
        Optional<Survey> option = repository.findById(new ObjectId(id));

        if(option.isEmpty()) {
            throw new Exception("Survey not found!");
        }

        return option.get();
    }

    public static Survey updateSurvey(Survey current, Survey update) {
        current.setName(update.getName());
        current.setDescription(update.getDescription());
        current.setStatus(update.getStatus());
        current.setQuestionList(update.getQuestionList());

        return current;
    }

    public void validateSurvey(Survey survey) throws Exception {
        if(
                survey.getName().isBlank() || survey.getName().isEmpty() ||
                survey.getDescription().isBlank() || survey.getDescription().isEmpty()
        ) {
            throwError("Required fields not set!");
        }
        else {
            validateQuestions(survey.getQuestionList());
        }
    }

    public void validateQuestions(List<Question> questionList) {

    }

    public void throwError(String message) throws Exception {
        throw new Exception(message);
    }
}
