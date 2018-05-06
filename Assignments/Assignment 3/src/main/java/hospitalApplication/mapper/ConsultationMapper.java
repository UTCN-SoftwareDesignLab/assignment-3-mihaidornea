package hospitalApplication.mapper;

import hospitalApplication.dto.ConsultationDto;
import hospitalApplication.dto.PatientDto;
import hospitalApplication.dto.UserDto;
import hospitalApplication.dto.builder.ConsultationDtoBuilder;
import hospitalApplication.entity.Consultation;
import hospitalApplication.entity.Patient;
import hospitalApplication.entity.User;
import hospitalApplication.entity.builder.ConsultationBuilder;

public class ConsultationMapper implements Mapper<Consultation, ConsultationDto> {

    private Mapper mapper = new UserMapper();
    private Mapper mapper1 = new PatientMapper();

    @Override
    public Consultation mapTo(ConsultationDto consultationDto) {
        return new ConsultationBuilder()
                .setDateOfConsultation(consultationDto.getDateOfConsultation())
                .setDoctor((User)mapper.mapTo(consultationDto.getDoctor()))
                .setDescription(consultationDto.getDescription())
                .setPatient((Patient)mapper1.mapTo(consultationDto.getPatient()))
                .build();
    }

    @Override
    public ConsultationDto mapFrom(Consultation consultation) {
        return new ConsultationDtoBuilder()
                .setDateOfConsultation(consultation.getDateOfConsultation())
                .setDescription(consultation.getDescription())
                .setDoctor((UserDto)mapper.mapFrom(consultation.getDoctor()))
                .setPatient((PatientDto)mapper1.mapFrom(consultation.getPatient()))
                .build();
    }
}
