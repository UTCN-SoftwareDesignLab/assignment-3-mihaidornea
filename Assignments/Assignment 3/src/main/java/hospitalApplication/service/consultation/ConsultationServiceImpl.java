package hospitalApplication.service.consultation;

import hospitalApplication.dto.ConsultationDto;
import hospitalApplication.entity.Consultation;
import hospitalApplication.entity.Patient;
import hospitalApplication.entity.User;
import hospitalApplication.mapper.ConsultationMapper;
import hospitalApplication.mapper.Mapper;
import hospitalApplication.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private ConsultationRepository consultationRepository;
    private Mapper mapper;

    @Autowired
    public ConsultationServiceImpl(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
        this.mapper = new ConsultationMapper();
    }

    @Override
    public boolean create(ConsultationDto consultationDto) {
        consultationRepository.save((Consultation)mapper.mapTo(consultationDto));
        return true;
    }

    @Override
    public ConsultationDto findByDoctorAndPatientAndDateOfConsultation(User doctor, Patient patient, Date dateOfConsultation) {
        return (ConsultationDto)mapper.mapFrom(consultationRepository.findByDateOfConsultationAndDoctorAndPatient(dateOfConsultation,patient,doctor));
    }

    @Override
    public List<ConsultationDto> findByPatient(Patient patient) {
        List<Consultation> consultations = consultationRepository.findByPatient(patient);
        List<ConsultationDto> consultationDtos = new ArrayList<>();
        for (Consultation consultation : consultations){
            consultationDtos.add((ConsultationDto)mapper.mapFrom(consultation));
        }
        return consultationDtos;
    }
}
