package clinic.recordmanagement.appointment;

import clinic.recordmanagement.requests.NewAppointment;
import clinic.recordmanagement.schemas.AppointmentSchema;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    public NewAppointment create(@RequestBody NewAppointment appointment);
    public List<AppointmentSchema> getAll();
    public List<NewAppointment> getTodaysAppointments(@RequestBody NewAppointment today);
}
