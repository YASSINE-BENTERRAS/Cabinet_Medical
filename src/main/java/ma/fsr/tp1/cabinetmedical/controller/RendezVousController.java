package ma.fsr.tp1.cabinetmedical.controller;

import ma.fsr.tp1.cabinetmedical.dto.RendezVousRequestDto;
import ma.fsr.tp1.cabinetmedical.entity.RendezVous;
import ma.fsr.tp1.cabinetmedical.entity.Statu;
import ma.fsr.tp1.cabinetmedical.repository.RendezVousRepo;
import ma.fsr.tp1.cabinetmedical.service.RendezVousService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rendezVous")

public class RendezVousController {
    RendezVousService  rendezVousService ;
    RendezVousRepo rendezVousRepo ;
    RendezVousController(RendezVousService rendezVousService , RendezVousRepo rendezVousRepo){
        this.rendezVousService = rendezVousService;
        this.rendezVousRepo = rendezVousRepo;
    }

    @GetMapping("/{id}")
    public List<RendezVous> getRendezVousByMedecin(@PathVariable Long id ){
        return rendezVousService.getRdvByMedecin(id);
    }

    @GetMapping()
    public List<RendezVous> getAll(){
        return rendezVousService.getAll();
    }

    @GetMapping("/byPatientName")
    public List<RendezVous> getRendezVousByPatient(@PathVariable Long id ){
        return rendezVousService.getRdvByPatient(id);
    }


    @GetMapping("/byDate")
    public List<RendezVous> getRendezVousByDate(@RequestParam LocalDate dateRdv){
        return rendezVousService.getRdvBydate(dateRdv);
    }

    @GetMapping("/ByStatu")
    public List<RendezVous> getRendezVousByStatus(@RequestParam Statu statu){
        return rendezVousService.getRdvByStatu(statu);
    }

    @PostMapping
    public RendezVous createRendezVous(@RequestBody RendezVousRequestDto rdv ){
        return rendezVousService.addRendezVous(rdv) ;

    }




}
