package com.employeetracker.model;

import org.springframework.stereotype.Component;

@Component
public class SalariedEmployee extends Employee {

    private static final int MAX_VACATION_DAYS = 15;

    public void setDaysWorked(int daysWorked) {
        super.setDaysWorked(daysWorked);
        updateVacationDays();
    }

    @Override
    public void takeVacation(float vacationDaysRequested) {
        if(vacationDaysRequested <= getVacationDays() - getVacationDaysRequested()) {
            setVacationDaysRequested(vacationDaysRequested);
        } else {
            throw new RuntimeException("No more vacation Days Left.");
        }
    }

    private void updateVacationDays() {
        float vacationDays = (float)(getDaysWorked() * MAX_VACATION_DAYS) / 260;
        if(vacationDays > MAX_VACATION_DAYS) {
            throw  new RuntimeException("Reached max vacation accrual limit.");
        }
        setVacationDays(vacationDays);
    }
}