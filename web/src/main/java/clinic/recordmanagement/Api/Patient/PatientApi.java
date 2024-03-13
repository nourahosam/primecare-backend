package clinic.recordmanagement.Api.Patient;
//
import clinic.recordmanagement.patient.PatientService;
import clinic.recordmanagement.requests.NewPatient;
import clinic.recordmanagement.schemas.PatientSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/patient")
public class PatientApi {
//
    @Autowired
    PatientService patientService;

    @PostMapping
    public ResponseEntity<NewPatient> createPatient(@RequestBody NewPatient request){
        NewPatient result = patientService.create(request);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PatientSchema>> getPatient(){
        List<PatientSchema> res = patientService.getAll();
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

}
