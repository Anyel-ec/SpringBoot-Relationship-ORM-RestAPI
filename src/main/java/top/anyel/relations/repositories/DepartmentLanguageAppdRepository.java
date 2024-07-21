package top.anyel.relations.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import top.anyel.relations.models.DepartmentLanguageAppd;
import top.anyel.relations.models.DepartmentLanguageKeyAppd;

public interface DepartmentLanguageAppdRepository extends JpaRepository<DepartmentLanguageAppd, DepartmentLanguageKeyAppd> {
}
