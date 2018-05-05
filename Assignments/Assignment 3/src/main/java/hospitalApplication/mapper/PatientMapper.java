package hospitalApplication.mapper;

import hospitalApplication.dto.PatientDto;
import hospitalApplication.dto.builder.PatientDtoBuilder;
import hospitalApplication.entity.Patient;
import hospitalApplication.entity.builder.PatientBuilder;

public class PatientMapper implements Mapper<Patient, PatientDto> {

    @Override
    public Patient mapTo(PatientDto patientDto) {
        return new PatientBuilder()
                .setAddress(patientDto.getAddress())
                .setDateOfBirth(patientDto.getDateOfBirth())
                .setIdentityNumber(patientDto.getIdentityNumber())
                .setName(patientDto.getName())
                .setPersonalNumber(patientDto.getPersonalNumber())
                .build();

    }

    @Override
    public PatientDto mapFrom(Patient patient) {
        return new PatientDtoBuilder()
                .setAddress(patient.getAddress())
                .setDateOfBirth(patient.getDateOfBirth())
                .setIdentityNumber(patient.getIdentityNumber())
                .setName(patient.getName())
                .setPersonalNumber(patient.getPersonalNumber())
                .build();
    }
}
