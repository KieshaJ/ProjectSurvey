package com.kj.dashboardapi.repositories;

import com.kj.dashboardapi.models.Statistic;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticRepository extends MongoRepository<Statistic, ObjectId> {
}
