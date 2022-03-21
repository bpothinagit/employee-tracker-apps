package com.employeetracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @JsonProperty("id")
    private int id;
    @JsonProperty("daysWorked")
    private int daysWorked;
    @JsonProperty("vacationDaysRequested")
    private float vacationDaysRequested;
    @JsonProperty("vacationDays")
    private float vacationDays;

    public float getVacationDaysRequested() {
        return vacationDaysRequested;
    }

    protected void setVacationDaysRequested(float vacationDaysRequested) {
        this.vacationDaysRequested = this.vacationDaysRequested + vacationDaysRequested;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected void setVacationDays(float vacationDays) {
        this.vacationDays = vacationDays;
    }

    public float getVacationDays() {
        return vacationDays;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void takeVacation(float vacationDaysRequested) {
        throw new RuntimeException();
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = getDaysWorked() + daysWorked;
    }
}