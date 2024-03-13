package clinic.recordmanagement.repository;

import clinic.recordmanagement.requests.NewAppointment;
import clinic.recordmanagement.schemas.AppointmentSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


public interface AppointmentRepository extends JpaRepository<AppointmentSchema, Long> {

    @Query("select a from appointment a where a.date = :todaysDate")
    Collection<NewAppointment> findAllWithDate(@Param("todaysDate") LocalDate todaysDate);
}
