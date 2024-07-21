package top.anyel.relations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.anyel.relations.models.EmployeeAppd;
import top.anyel.relations.services.EmployeeAppdService;

import java.util.List;

@RestController
@RequestMapping("/employeesAppd")
public class EmployeeAppdController {
    @Autowired
    private EmployeeAppdService employeeAppdService;

    @GetMapping
    public List<EmployeeAppd> getAllEmployees() {
        return employeeAppdService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeAppd> getEmployeeById(@PathVariable Integer id) {
        return employeeAppdService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public List<EmployeeAppd> createEmployees(@RequestBody List<EmployeeAppd> employeesAppd) {
        return employeeAppdService.saveEmployees(employeesAppd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeAppd> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeAppd employeeAppd) {
        return employeeAppdService.getEmployeeById(id)
                .map(existingEmployee -> {
                    employeeAppd.setEmployeeIdAppd(existingEmployee.getEmployeeIdAppd());
                    return ResponseEntity.ok(employeeAppdService.saveEmployee(employeeAppd));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeAppdService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
