package top.anyel.relations.models;

import jakarta.persistence.*;
import lombok.Data;
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

    @OneToMany(mappedBy = "departmentAppd")
    private List<EmployeeAppd> employeesAppd;

    @OneToMany(mappedBy = "departmentAppd")
    private List<DepartmentLanguageAppd> departmentLanguagesAppd;

}
