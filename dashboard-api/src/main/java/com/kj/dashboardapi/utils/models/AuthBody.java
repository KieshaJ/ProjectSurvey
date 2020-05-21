package com.kj.dashboardapi.utils.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthBody {
    private String username;
    private String password;
}
