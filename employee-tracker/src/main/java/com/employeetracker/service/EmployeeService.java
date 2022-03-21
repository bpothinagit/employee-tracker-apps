package com.employeetracker.service;

import com.employeetracker.model.Employee;
import com.employeetracker.model.HourlyEmployee;
import com.employeetracker.model.ManagerialEmployee;
import com.employeetracker.model.SalariedEmployee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeService {

    Map<Integer, Employee> employees = new HashMap<>();

    public EmployeeService() {
        for(int i = 1; i <= 10; i++) {
            Employee hourly = new HourlyEmployee();
            hourly.setId(i);
            employees.put(hourly.getId(), hourly);

            Employee salariedEmployee = new SalariedEmployee();
            salariedEmployee.setId(i + 10);
            employees.put(salariedEmployee.getId(), salariedEmployee);

            Employee managerialEmployee = new ManagerialEmployee();
            managerialEmployee.setId(i + 20);
            employees.put(managerialEmployee.getId(), managerialEmployee);
        }
    }

    public Map<Integer, Employee> work(final int employeeId, final int daysWorked)  {
        Employee employee = employees.get(employeeId);
        if (employee.getDaysWorked() + daysWorked > 260) {
            throw new RuntimeException("Cannot work over 260 days per year.");
        }

        employee.setDaysWorked(daysWorked);
        return employees;
    }

    public Map<Integer, Employee> takeVacation(final int employeeId, final float vacationDaysRequested) {
        Employee employee = employees.get(employeeId);
        employee.takeVacation(vacationDaysRequested);
        return employees;
    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }
}
