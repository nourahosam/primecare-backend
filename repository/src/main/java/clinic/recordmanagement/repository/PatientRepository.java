package clinic.recordmanagement.repository;

import clinic.recordmanagement.schemas.PatientSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientSchema, Long> {
    public PatientSchema findAllByPhoneNo(String phoneNo);
}
