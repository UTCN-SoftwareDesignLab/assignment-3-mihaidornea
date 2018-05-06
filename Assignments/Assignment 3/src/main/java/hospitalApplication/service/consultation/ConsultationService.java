package hospitalApplication.service.consultation;

import hospitalApplication.dto.ConsultationDto;
import hospitalApplication.dto.PatientDto;
import hospitalApplication.dto.UserDto;
import hospitalApplication.entity.Consultation;
import hospitalApplication.entity.Patient;
import hospitalApplication.entity.User;

import java.util.Date;
import java.util.List;

public interface ConsultationService {

    boolean create(ConsultationDto consultationDto);
    ConsultationDto findByDoctorAndPatientAndDateOfConsultation(UserDto doctor, PatientDto patientDto, Date dateOfConsultation);
    List<ConsultationDto> findByPatient(PatientDto patientDto);
    boolean update(ConsultationDto consultationDto, String newDescription);

}
