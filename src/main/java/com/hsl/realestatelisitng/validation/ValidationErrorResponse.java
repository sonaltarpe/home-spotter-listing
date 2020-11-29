package com.hsl.realestatelisitng.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This class sends the response/ validation error failures

public class ValidationErrorResponse {
    private Map<String, String> errors;

    public ValidationErrorResponse() {
        this.errors = new HashMap<>();
    }
    public Map<String, String>getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}

