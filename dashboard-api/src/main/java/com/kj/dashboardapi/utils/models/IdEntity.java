package com.kj.dashboardapi.utils.models;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class IdEntity {
    @Id
    private ObjectId id;

    public IdEntity(ObjectId id) {
        this.id = id;
    }

    public String getIdAsString() {
        return id.toString();
    }

    public void setIdFromString(String id) {
        this.id = new ObjectId(id);
    }
}
