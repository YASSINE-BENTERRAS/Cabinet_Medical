package ma.fsr.tp1.cabinetmedical.controller;

import ma.fsr.tp1.cabinetmedical.entity.Medecin;
import ma.fsr.tp1.cabinetmedical.service.MedecinService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medecin")

public class MedecinController {
    MedecinService medecinService ;
    public MedecinController(MedecinService medecinService){
        this.medecinService = medecinService;
    }

    @GetMapping("/{id}")
    public Medecin getMedecinById(@PathVariable Long id) {
        return medecinService.getMedecinById(id);

    }

    @GetMapping
    public List<Medecin> getByName(@RequestParam String nom) {
        return medecinService.getMedecinsByNom(nom);
    }

    @PostMapping
    public Medecin addMedecin(@RequestBody Medecin medecin){
        return medecinService.addMedecin(medecin);
    }

    @DeleteMapping
    public void deleteMedecin(@RequestBody Medecin medecin){
        medecinService.deleteMedecin(medecin);
    }


}
