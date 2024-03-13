package clinic.recordmanagement.schemas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name = "appointment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppointmentSchema {
    @Id
    @Column(name = "id")
//    @Temporal(TemporalType.TIMESTAMP)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aptId;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "time")
    private LocalTime time;

//    @JsonBackReference("patient_appt")
//    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="patient_id")
    private Long patientId;

}
