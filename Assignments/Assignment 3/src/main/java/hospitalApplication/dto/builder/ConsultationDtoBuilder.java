package hospitalApplication.dto.builder;

import hospitalApplication.dto.ConsultationDto;
import hospitalApplication.dto.PatientDto;
import hospitalApplication.dto.UserDto;
import hospitalApplication.entity.Patient;
import hospitalApplication.entity.User;

import java.util.Date;

public class ConsultationDtoBuilder {

    private ConsultationDto consultationDto;

    public ConsultationDtoBuilder() {
        this.consultationDto = new ConsultationDto();
    }

    public ConsultationDtoBuilder setDateOfConsultation(Date dateOfConsultation){
        consultationDto.setDateOfConsultation(dateOfConsultation);
        return this;
    }

    public ConsultationDtoBuilder setPatient(PatientDto patient){
        consultationDto.setPatient(patient);
        return this;
    }

    public ConsultationDtoBuilder setDoctor(UserDto doctor){
        consultationDto.setDoctor(doctor);
        return this;
    }

    public ConsultationDto build(){
        return consultationDto;
    }

}
