package com.kj.dashboardapi.repositories;

import com.kj.dashboardapi.models.Question;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, ObjectId> {
}
