package be.g00glen00b.apps;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    @Schema(description = "The unique identifier of the employee")
    private Long id;
    @Schema(description = "The full name of the employee")
    private String name;
    @Schema(description = "The job title of the employee")
    private String title;
    @Schema(description = "The date at which the employee started to work")
    private LocalDate startdate;
}
