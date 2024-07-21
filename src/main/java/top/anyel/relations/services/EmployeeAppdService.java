package top.anyel.relations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.relations.models.EmployeeAppd;
import top.anyel.relations.repositories.EmployeeAppdRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAppdService {
    @Autowired
    private EmployeeAppdRepository employeeAppdRepository;

    public List<EmployeeAppd> getAllEmployees() {
        return employeeAppdRepository.findAll();
    }

    public Optional<EmployeeAppd> getEmployeeById(Integer id) {
        return employeeAppdRepository.findById(id);
    }

    public EmployeeAppd saveEmployee(EmployeeAppd employeeAppd) {
        return employeeAppdRepository.save(employeeAppd);
    }

    public void deleteEmployee(Integer id) {
        employeeAppdRepository.deleteById(id);
    }
}
