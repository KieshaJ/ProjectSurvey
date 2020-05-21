package com.kj.dashboardapi.services;

import com.kj.dashboardapi.models.Survey;
import com.kj.dashboardapi.utils.filters.SurveyFilter;
import org.springframework.data.domain.Page;

public interface SurveyService {
    Page<Survey> list(SurveyFilter filter);
    Survey save(Survey survey) throws Exception;
    Survey update(String id, Survey survey) throws Exception;
    String delete(String id);
}
