package hospitalApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {

    @GetMapping("/doctorHome")
    public String doctorHome(Model model){
        return "doctorHome";
    }

    @GetMapping("/seeHistory")
    public String seePastConsultations(Model model){
        return "redirect:/findConsultations";
    }

    @GetMapping("/addConsultationDescription")
    public String addDetailsToConsultations(Model model){
        return "redirect:/consultationUpdateForm";
    }

}
