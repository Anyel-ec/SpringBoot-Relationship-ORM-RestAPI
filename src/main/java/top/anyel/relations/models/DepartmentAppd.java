package top.anyel.relations.models;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "departmentsAppd")
@Data
public class DepartmentAppd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentIdAppd;

    private Integer locationIdAppd;

    private Byte statusAppd;

    private Date dateAddedAppd;

    @OneToMany(mappedBy = "departmentAppd", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<EmployeeAppd> employeesAppd;

    @OneToMany(mappedBy = "departmentAppd", cascade = CascadeType.ALL)
    private List<DepartmentLanguageAppd> departmentLanguagesAppd;
}
