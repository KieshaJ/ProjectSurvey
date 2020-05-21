package com.kj.dashboardapi.repositories;

import com.kj.dashboardapi.models.Submission;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubmissionRepository extends MongoRepository<Submission, ObjectId> {
}
