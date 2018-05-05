package hospitalApplication.service.patient;

import hospitalApplication.dto.PatientDto;
import hospitalApplication.entity.Patient;
import hospitalApplication.mapper.Mapper;
import hospitalApplication.mapper.PatientMapper;
import hospitalApplication.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private Mapper mapper;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        this.mapper = new PatientMapper();
    }

    @Override
    public List<PatientDto> findAll() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientDtos = new ArrayList<>();
        for (Patient patient : patients){
            patientDtos.add((PatientDto)mapper.mapFrom(patient));
        }
        return patientDtos;
    }

    @Override
    public PatientDto findByPersonalNumber(Long personalNumber) {
        return (PatientDto)mapper.mapFrom(patientRepository.findByPersonalNumber(personalNumber));
    }

    @Override
    public boolean update(PatientDto patientDto, String newAddress) {
        patientRepository.updatePatientAddress(newAddress, patientDto.getPersonalNumber());
        return true;
    }

    @Override
    public boolean create(PatientDto patientDto) {
        patientRepository.save((Patient)mapper.mapTo(patientDto));
        return false;
    }
}