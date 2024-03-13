package clinic.recordmanagement.Api.Patient;

import clinic.recordmanagement.appointment.AppointmentService;
import clinic.recordmanagement.requests.NewAppointment;
import clinic.recordmanagement.schemas.AppointmentSchema;
import clinic.recordmanagement.schemas.PatientSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/appointment")
public class AppointmentApi {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Object> createApp(@RequestBody NewAppointment appointment){
        NewAppointment response = appointmentService.create(appointment);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<AppointmentSchema> response = appointmentService.getAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/getByDate")
    public ResponseEntity<Object> getTodaysAppointments(@RequestBody NewAppointment appointment){

        System.out.println("Infooo"+ appointment.toString());
        List<NewAppointment> response = appointmentService.getTodaysAppointments(appointment);
        return ResponseEntity.ok(response);
    }
}
