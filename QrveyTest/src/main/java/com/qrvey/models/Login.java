package com.qrvey.models;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Login {
    private String user;
    private String password;
}