package clinic.recordmanagement.schemas;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "patient")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="phone_no")
    private String phoneNo;

    @Column(name="date_of_first_visit")
    private LocalDate dateOfFirstVisit;

    @Column(name="dob")
    private LocalDate DOB;
}
