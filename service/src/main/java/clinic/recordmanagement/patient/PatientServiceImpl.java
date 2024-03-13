package clinic.recordmanagement.patient;

import clinic.recordmanagement.repository.PatientRepository;
import clinic.recordmanagement.requests.NewPatient;
import clinic.recordmanagement.schemas.PatientSchema;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;


    final ModelMapper modelMapper = new ModelMapper();

    @Override
    public NewPatient create(@RequestBody NewPatient request){
        PatientSchema patientSchema = new PatientSchema();
        modelMapper.map(request, patientSchema);
        PatientSchema savedObject = patientRepository.save(patientSchema);

        NewPatient response = new NewPatient();
        modelMapper.map(savedObject, response);

        return response;
    }

    @Override
    public List<PatientSchema> getAll(){
    List<PatientSchema> res = patientRepository.findAll();
    return res;
    }

    @Override
    public PatientSchema getOne(@PathVariable Long id){
        return patientRepository.findById(id).orElseThrow(()-> new RuntimeException("id not found"));
    }

    @Override
    public PatientSchema getByPhoneNo(@RequestBody String phoneNo){
        return patientRepository.findAllByPhoneNo(phoneNo);
    }
}
