package com.employeetracker.model;

import com.employeetracker.exception.EmployeeStatusException;
import org.springframework.stereotype.Component;

@Component
public class HourlyEmployee extends Employee {

    private static final int MAX_VACATION_DAYS = 10;

    public void setDaysWorked(int daysWorked) {
        super.setDaysWorked(daysWorked);
        updateVacationDays();
    }

    @Override
    public void takeVacation(float vacationDaysRequested) {
        if(vacationDaysRequested <= getVacationDays() - getVacationDaysRequested()) {
            setVacationDaysRequested(vacationDaysRequested);
        } else {
            throw new EmployeeStatusException("No more vacation Days Left.");
        }
    }

    private void updateVacationDays() {
        float vacationDays = (float)(getDaysWorked() * MAX_VACATION_DAYS) / 260;
        if(vacationDays > MAX_VACATION_DAYS) {
            throw  new EmployeeStatusException("Reached maximum vacation days accrual limit.");
        }
        setVacationDays(vacationDays);
    }
}