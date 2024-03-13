package clinic.recordmanagement.appointment;

import clinic.recordmanagement.patient.PatientService;
import clinic.recordmanagement.repository.AppointmentRepository;
import clinic.recordmanagement.requests.NewAppointment;
import clinic.recordmanagement.schemas.AppointmentSchema;
import clinic.recordmanagement.schemas.PatientSchema;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientService patientService;

    final ModelMapper modelMapper = new ModelMapper();

    @Override
    public NewAppointment create(@RequestBody NewAppointment appointment){
        PatientSchema patient = patientService.getByPhoneNo(appointment.getPhoneNo());

        AppointmentSchema appointmentSchema = new AppointmentSchema();
        modelMapper.map(appointment, appointmentSchema);
        appointmentSchema.setPatient(patient);
        appointmentSchema = appointmentRepository.save(appointmentSchema);

        NewAppointment result = new NewAppointment();
        modelMapper.map(appointmentSchema, result);
        result.setPatientId(appointment.getPatientId());
        result.setPhoneNo(appointment.getPhoneNo());

        return result;

    };

    @Override
    public List<AppointmentSchema> getAll(){
        return appointmentRepository.findAll();
    };

    @Override
    public List<NewAppointment> getTodaysAppointments(@RequestBody NewAppointment today){
        System.out.println("Todays date: " + today.getDate());
        return appointmentRepository.findAllWithDate(today.getDate()).stream().toList();
    }
}
