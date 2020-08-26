package com.kj.dashboardapi.controllers;

import com.kj.dashboardapi.models.Survey;
import com.kj.dashboardapi.services.SurveyService;
import com.kj.dashboardapi.utils.filters.SurveyFilter;
import com.kj.dashboardapi.utils.responses.SurveyListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/surveys")
@CrossOrigin(origins = "http://localhost:3000")
@Secured("USER")
public class SurveyController {
    @Autowired
    private SurveyService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<SurveyListResponse> list(@RequestBody SurveyFilter filter) {
        Page<Survey> surveys = service.list(filter);
        SurveyListResponse response = new SurveyListResponse(surveys, filter);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Survey save(@RequestBody Survey survey) throws Exception {
        return service.save(survey);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Survey update(@PathVariable String id, @RequestBody Survey survey) throws Exception {
        return service.update(id, survey);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        return service.delete(id);
    }
}
