package com.kj.dashboardapi.services.impl;

import com.kj.dashboardapi.models.Question;
import com.kj.dashboardapi.models.Survey;
import com.kj.dashboardapi.repositories.AnswerRepository;
import com.kj.dashboardapi.repositories.QuestionRepository;
import com.kj.dashboardapi.repositories.StatisticRepository;
import com.kj.dashboardapi.repositories.SurveyRepository;
import com.kj.dashboardapi.services.SurveyService;
import com.kj.dashboardapi.utils.StatisticUtils;
import com.kj.dashboardapi.utils.SurveyUtils;
import com.kj.dashboardapi.utils.filters.SurveyFilter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SurveyServiceImpl implements SurveyService {
    private final MongoTemplate mongoTemplate;
    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final StatisticRepository statisticRepository;

    @Autowired
    public SurveyServiceImpl(
            MongoTemplate mongoTemplate, SurveyRepository surveyRepository,
            QuestionRepository questionRepository, AnswerRepository answerRepository,
            StatisticRepository statisticRepository
            ) {
        this.mongoTemplate = mongoTemplate;
        this.surveyRepository = surveyRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.statisticRepository = statisticRepository;
    }

    @Override
    public Page<Survey> list(SurveyFilter filter) {
        Pageable pageRequest = PageRequest.of(filter.getPage(), filter.getPageSize());
        Query query = SurveyUtils.queryFromFilter(filter);
        query.with(pageRequest);

        List<Survey> surveyList = mongoTemplate.find(query, Survey.class);
        return PageableExecutionUtils.getPage(surveyList, pageRequest, surveyRepository::count);
    }

    @Override
    public Survey save(Survey survey) {
        List<Question> savedQuestions = SurveyUtils.saveQuestions(survey.getQuestionList(), questionRepository, answerRepository);

        survey.setQuestionList(savedQuestions);
        survey = surveyRepository.save(survey);

        String surveyId = survey.getId().toString();
        StatisticUtils.saveStatistics(savedQuestions, surveyId, statisticRepository);

        return survey;
    }

    @Override
    public Survey update(String id, Survey update) throws Exception {
        Survey current = SurveyUtils.findSurvey(id, surveyRepository);
        Survey updated = SurveyUtils.updateSurvey(current, update);
        surveyRepository.save(updated);
        return updated;
    }

    @Override
    public String delete(String id) {
        surveyRepository.deleteById(new ObjectId(id));
        return id;
    }
}
