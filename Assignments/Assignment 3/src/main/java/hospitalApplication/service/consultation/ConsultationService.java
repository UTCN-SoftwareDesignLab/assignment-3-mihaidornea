package hospitalApplication.service.consultation;

import hospitalApplication.dto.ConsultationDto;
import hospitalApplication.entity.Consultation;
import hospitalApplication.entity.Patient;
import hospitalApplication.entity.User;

import java.util.Date;
import java.util.List;

public interface ConsultationService {

    boolean create(ConsultationDto consultationDto);
    ConsultationDto findByDoctorAndPatientAndDateOfConsultation(User doctor, Patient patient, Date dateOfConsultation);
    List<ConsultationDto> findByPatient(Patient patient);

}
