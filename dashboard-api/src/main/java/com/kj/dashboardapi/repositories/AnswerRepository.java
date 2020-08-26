package com.kj.dashboardapi.repositories;

import com.kj.dashboardapi.models.Answer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswerRepository extends MongoRepository<Answer, ObjectId> {
}
