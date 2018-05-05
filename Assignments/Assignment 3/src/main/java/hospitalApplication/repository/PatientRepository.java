package hospitalApplication.repository;

import hospitalApplication.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByPersonalNumber(Long personalNumber);
    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.address = :newAddress WHERE p.personalNumber = :personalNumber")
    void updatePatientAddress(@Param("newAddress") String newAddress, @Param("personalNumber") Long personalNumber);


}
