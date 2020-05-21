package com.kj.dashboardapi.utils.responses;

import com.kj.dashboardapi.models.Survey;
import com.kj.dashboardapi.utils.filters.SurveyFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Getter
public class SurveyListResponse {
    private final Page<Survey> surveys;
    private final SurveyFilter filter;
}
