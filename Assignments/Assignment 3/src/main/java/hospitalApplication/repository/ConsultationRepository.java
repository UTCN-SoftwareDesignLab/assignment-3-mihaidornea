package hospitalApplication.repository;

import hospitalApplication.entity.Consultation;
import hospitalApplication.entity.Patient;
import hospitalApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    Consultation findByDateOfConsultationAndDoctorAndPatient(Date dateOfConsultation, Patient patient, User doctor);
    List<Consultation> findByPatient(Patient patient);

}
