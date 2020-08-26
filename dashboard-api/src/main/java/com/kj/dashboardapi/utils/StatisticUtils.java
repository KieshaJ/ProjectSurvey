package com.kj.dashboardapi.utils;

import com.kj.dashboardapi.models.Answer;
import com.kj.dashboardapi.models.Question;
import com.kj.dashboardapi.models.Statistic;
import com.kj.dashboardapi.repositories.StatisticRepository;
import com.kj.dashboardapi.utils.enums.QuestionType;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticUtils {
    public static List<Statistic> saveStatistics(List<Question> questionList, String surveyId, StatisticRepository statisticRepository) {
        return statisticRepository.saveAll(statisticsFromQuestions(questionList, surveyId));
    }

    public static List<Statistic> statisticsFromQuestions(List<Question> questionList, String surveyId) {
        Set<QuestionType> types = Set.of(QuestionType.SINGLE_SELECT, QuestionType.MULTI_SELECT, QuestionType.LOGICAL);
        List<Statistic> statisticList = new ArrayList<>();

        questionList.forEach(question -> {
            if(types.contains(question.getQuestionType())) {
                statisticList.add(statisticFromQuestion(question, surveyId));
            }
        });

        return statisticList;
    }

    public static Statistic statisticFromQuestion(Question question, String surveyId) {
        Statistic statistic = new Statistic(null, surveyId, question.getQuestion(), new HashMap<>());

        Map<String, Integer> answerCounts = question
                .getAnswerList()
                .stream()
                .collect(Collectors.toMap(Answer::getAnswer, answer -> 0));

        statistic.setAnswerCounts(answerCounts);
        return statistic;
    }
}
