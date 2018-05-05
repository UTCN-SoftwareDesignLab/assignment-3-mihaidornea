package hospitalApplication.controller;

import hospitalApplication.dto.PatientDto;
import hospitalApplication.entity.Patient;
import hospitalApplication.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class PatientFormController {

    PatientService patientService;

    @Autowired
    public PatientFormController(PatientService patientService) {
        this.patientService = patientService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/patientCreateForm")
    public String createForm(PatientDto patientDto){
        return "/patientCreateForm";
    }

    @PostMapping("/patientCreateForm")
    public String createPatient(@Valid PatientDto patientDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/patientCreateForm";
        }
        patientService.create(patientDto);
        return "/secretarySuccess";
    }


    @GetMapping("/patientUpdateForm")
    public String updateForm(Model model){
        return "/patientUpdateForm";
    }

    @PostMapping("/patientUpdateForm")
    public String updatePatient (@RequestParam Map<String, String> field){
        PatientDto patientDto = patientService.findByPersonalNumber(Long.parseLong(field.get("personalCode")));
        patientService.update(patientDto, field.get("newAddress"));
        return "/secretarySuccess";
    }

    @GetMapping("/patientFindForm")
    public String findForm(Model model){
        return "/patientFindForm";
    }

    @PostMapping("/patientFindForm")
    public ModelAndView findPatient(@RequestParam Map<String, String> field){
        PatientDto patientDto = patientService.findByPersonalNumber(Long.parseLong(field.get("personalNumber")));
        ModelAndView mav = new ModelAndView("patientFound");
        if (patientDto != null){
            mav.addObject("patient", patientDto);
        }
        return mav;
    }

}
