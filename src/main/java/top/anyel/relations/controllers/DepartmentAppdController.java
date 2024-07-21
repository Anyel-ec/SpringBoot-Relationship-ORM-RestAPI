package top.anyel.relations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.anyel.relations.models.DepartmentAppd;
import top.anyel.relations.services.DepartmentAppdService;

import java.util.List;

@RestController
@RequestMapping("/departmentsAppd")
public class DepartmentAppdController {
    @Autowired
    private DepartmentAppdService departmentAppdService;

    @GetMapping
    public List<DepartmentAppd> getAllDepartments() {
        return departmentAppdService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentAppd> getDepartmentById(@PathVariable Integer id) {
        return departmentAppdService.getDepartmentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public List<DepartmentAppd> createDepartments(@RequestBody List<DepartmentAppd> departmentsAppd) {
        return departmentAppdService.saveDepartments(departmentsAppd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentAppd> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentAppd departmentAppd) {
        return departmentAppdService.getDepartmentById(id)
                .map(existingDepartment -> {
                    departmentAppd.setDepartmentIdAppd(existingDepartment.getDepartmentIdAppd());
                    return ResponseEntity.ok(departmentAppdService.saveDepartment(departmentAppd));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id) {
        departmentAppdService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
