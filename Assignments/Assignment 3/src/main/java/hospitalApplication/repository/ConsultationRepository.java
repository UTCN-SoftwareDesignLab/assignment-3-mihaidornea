package hospitalApplication.repository;

import hospitalApplication.entity.Consultation;
import hospitalApplication.entity.Patient;
import hospitalApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    Consultation findByDateOfConsultationAndDoctorAndPatient(Date dateOfConsultation, User doctor, Patient patient);
    List<Consultation> findByPatientAndDateOfConsultationBefore(Patient patient, Date date);
    @Transactional
    @Modifying
    @Query("UPDATE Consultation c SET c.description = :newDescription WHERE c.id = :id")
    void updateDescription(@Param("newDescription") String newDescription, @Param("id") Long id);
}
