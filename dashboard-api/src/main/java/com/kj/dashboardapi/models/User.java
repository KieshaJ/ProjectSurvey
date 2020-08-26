package com.kj.dashboardapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kj.dashboardapi.utils.enums.UserRole;
import com.kj.dashboardapi.utils.models.IdEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Document
@Getter
@Setter
public class User extends IdEntity {
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String username;
    private String password;
    @Min(1)
    private List<UserRole> roles;

    public User(ObjectId id, String name, String lastName, String username, String password, List<UserRole> roles) {
        super(id);
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
