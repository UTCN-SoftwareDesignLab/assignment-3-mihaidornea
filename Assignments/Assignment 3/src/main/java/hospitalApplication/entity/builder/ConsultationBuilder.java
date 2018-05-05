package hospitalApplication.entity.builder;

import hospitalApplication.entity.Consultation;
import hospitalApplication.entity.Patient;
import hospitalApplication.entity.User;

import java.util.Date;

public class ConsultationBuilder {

    private Consultation consultation;

    public ConsultationBuilder() {
        this.consultation = new Consultation();
    }

    public ConsultationBuilder setDateOfConsultation(Date dateOfConsultation){
        consultation.setDateOfConsultation(dateOfConsultation);
        return this;
    }

    public ConsultationBuilder setPatient(Patient patient){
        consultation.setPatient(patient);
        return this;
    }

    public ConsultationBuilder setDoctor(User doctor){
        consultation.setDoctor(doctor);
        return this;
    }

    public Consultation build(){
        return consultation;
    }
}