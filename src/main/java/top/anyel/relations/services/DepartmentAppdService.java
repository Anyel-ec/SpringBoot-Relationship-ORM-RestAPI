package top.anyel.relations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.relations.models.DepartmentAppd;
import top.anyel.relations.repositories.DepartmentAppdRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentAppdService {
    @Autowired
    private DepartmentAppdRepository departmentAppdRepository;

    public List<DepartmentAppd> getAllDepartments() {
        return departmentAppdRepository.findAll();
    }

    public Optional<DepartmentAppd> getDepartmentById(Integer id) {
        return departmentAppdRepository.findById(id);
    }

    public DepartmentAppd saveDepartment(DepartmentAppd departmentAppd) {
        return departmentAppdRepository.save(departmentAppd);
    }

    public List<DepartmentAppd> saveDepartments(List<DepartmentAppd> departmentsAppd) {
        return departmentAppdRepository.saveAll(departmentsAppd);
    }

    public void deleteDepartment(Integer id) {
        departmentAppdRepository.deleteById(id);
    }
}
