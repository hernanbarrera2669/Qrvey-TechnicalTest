package com.qrvey.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Checkout {
    private String name;
    private String lastName;
    private String zipCode;
}
