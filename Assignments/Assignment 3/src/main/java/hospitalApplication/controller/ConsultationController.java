package hospitalApplication.controller;

import hospitalApplication.dto.ConsultationDto;
import hospitalApplication.dto.PatientDto;
import hospitalApplication.dto.UserDto;
import hospitalApplication.service.consultation.ConsultationService;
import hospitalApplication.service.patient.PatientService;
import hospitalApplication.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ConsultationController {

    ConsultationService consultationService;
    UserService userService;
    PatientService patientService;

    @Autowired
    public ConsultationController(ConsultationService consultationService, UserService userService, PatientService patientService) {
        this.consultationService = consultationService;
        this.userService = userService;
        this.patientService = patientService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/consultationCreateForm")
    public String createForm(ConsultationDto consultationDto, PatientDto patientDto, UserDto userDto){
        return "/consultationCreateForm";
    }

    @PostMapping("/consultationCreateForm")
    public String createPatient(@Valid ConsultationDto consultationDto, PatientDto patientDto, UserDto userDto, BindingResult bindingResult){
        UserDto userDto1 = userService.findByUsername(userDto.getUsername());
        if (userDto1 != null) {
            if (userDto1.getRole() != "Doctor") {
                bindingResult.reject("doctor");
            }
        } else {
            bindingResult.reject("doctor");
            return "/consultationCreateForm";
        }

        PatientDto patientDto1 = patientService.findByPersonalNumber(patientDto.getPersonalNumber());
        if (patientDto1 == null){
            bindingResult.reject("patient");
            return "/consultationCreateForm";
        }

        if (bindingResult.hasErrors()){
            return "/consultationCreateForm";
        }

        consultationDto.setDoctor(userDto1);
        consultationDto.setPatient(patientDto1);
        consultationService.create(consultationDto);

        return "/secretarySuccess";
    }

}
