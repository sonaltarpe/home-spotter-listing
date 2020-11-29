package com.hsl.realestatelisitng.validation;

import java.util.ArrayList;
import java.util.List;


public class ValidationErrorResponse {
    private List<String> violations;

    public ValidationErrorResponse() {
        this.violations = new ArrayList<>();
    }
    public List<String> getViolations() {
        return violations;
    }

    public void setViolations(List<String> violations) {
        this.violations = violations;
    }
}

