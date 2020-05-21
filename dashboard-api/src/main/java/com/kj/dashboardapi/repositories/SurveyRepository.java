package com.kj.dashboardapi.repositories;

import com.kj.dashboardapi.models.Survey;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurveyRepository extends MongoRepository<Survey, ObjectId> {
}
