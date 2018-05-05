package hospitalApplication.dto;

import hospitalApplication.dto.doctorValidation.DoctorConstraint;
import hospitalApplication.entity.Patient;
import hospitalApplication.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class ConsultationDto {

    @NotNull
    private PatientDto patient;

    @NotNull
    @DoctorConstraint(message = "You need to select a doctor")
    private UserDto doctor;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfConsultation;

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public UserDto getDoctor() {
        return doctor;
    }

    public void setDoctor(UserDto doctor) {
        this.doctor = doctor;
    }

    public Date getDateOfConsultation() {
        return dateOfConsultation;
    }

    public void setDateOfConsultation(Date dateOfConsultation) {
        this.dateOfConsultation = dateOfConsultation;
    }
}
