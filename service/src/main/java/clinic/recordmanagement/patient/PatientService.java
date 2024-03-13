package clinic.recordmanagement.patient;

import clinic.recordmanagement.requests.NewPatient;
import clinic.recordmanagement.schemas.PatientSchema;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PatientService {
    public NewPatient create(@RequestBody NewPatient patient);
    public List<PatientSchema> getAll();
    public PatientSchema getOne(@PathVariable Long id);
    public PatientSchema getByPhoneNo(@RequestBody String phoneNo);
}
