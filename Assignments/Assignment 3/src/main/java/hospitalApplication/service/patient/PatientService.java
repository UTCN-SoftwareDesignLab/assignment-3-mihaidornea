package hospitalApplication.service.patient;

import hospitalApplication.dto.PatientDto;
import hospitalApplication.entity.Patient;

import java.util.List;

public interface PatientService {

    List<PatientDto> findAll();
    PatientDto findByPersonalNumber(Long personalNumber);
    Patient findByPersonalNumberInternal(Long personalNumber);
    boolean update(PatientDto patientDto, String newAddress);
    boolean create(PatientDto patientDto);

}
