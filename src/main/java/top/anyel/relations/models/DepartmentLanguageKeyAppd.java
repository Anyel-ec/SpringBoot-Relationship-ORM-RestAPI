package top.anyel.relations.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class DepartmentLanguageKeyAppd implements Serializable {
    @Column(name = "department_idAppd")
    private Integer departmentIdAppd;

    @Column(name = "language_idAppd")
    private Integer languageIdAppd;
}
