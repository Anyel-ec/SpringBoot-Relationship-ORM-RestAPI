package top.anyel.relations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import top.anyel.relations.models.DepartmentAppd;

public interface DepartmentAppdRepository extends JpaRepository<DepartmentAppd, Integer> {
}
