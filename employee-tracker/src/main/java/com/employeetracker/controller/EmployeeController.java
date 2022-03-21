package com.employeetracker.controller;

import com.employeetracker.exception.EmployeeStatusException;
import com.employeetracker.model.Employee;
import com.employeetracker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(
            value = "/getAll",
            method = RequestMethod.GET
    )
    public Map<Integer, Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(
            value = "/work/{id}",
            method = RequestMethod.POST
    )
    public void work(@RequestBody final Employee employee, @PathVariable("id") final int employeeId) {
        if (employee.getDaysWorked() < 0 || employee.getDaysWorked() > 260) {
            throw new EmployeeStatusException("Work days should be in the range of 0 to 260");
        } else {
            employeeService.work(employeeId, employee.getDaysWorked());
        }
    }

    @RequestMapping(
            value = "/take-vacation/{id}",
            method = RequestMethod.POST
    )
    public void takeVacation(@RequestBody final Employee employee, @PathVariable("id") final int employeeId) {
        if (employee.getVacationDaysRequested() < 0) {
            throw new EmployeeStatusException("Negative value not allowed for Vacation Days requested");
        }
        employeeService.takeVacation(employeeId, employee.getVacationDaysRequested());
    }
}
