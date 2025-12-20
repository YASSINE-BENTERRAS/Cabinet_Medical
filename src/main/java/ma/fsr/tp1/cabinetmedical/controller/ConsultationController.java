package ma.fsr.tp1.cabinetmedical.controller;

import ma.fsr.tp1.cabinetmedical.dto.ConsultationRequestDto;
import ma.fsr.tp1.cabinetmedical.entity.Consultation;
import ma.fsr.tp1.cabinetmedical.repository.ConsultationRepo;
import ma.fsr.tp1.cabinetmedical.service.ConsultationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    private final ConsultationService consultationService;
    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping
    public Consultation addConsultation(@RequestBody ConsultationRequestDto requestDto){
        return consultationService.createConsultation(requestDto);
    }

    @GetMapping
    public List<Consultation> getAll(){
        return consultationService.getAll() ;
    }
    @GetMapping("/{id}")
    public Consultation getConsultationById(@PathVariable Long id){
        return consultationService.searchById(id);
    }
}
