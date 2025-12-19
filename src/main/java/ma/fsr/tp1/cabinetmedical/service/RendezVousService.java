package ma.fsr.tp1.cabinetmedical.service;

import jakarta.persistence.EntityNotFoundException;
import ma.fsr.tp1.cabinetmedical.entity.Medecin;
import ma.fsr.tp1.cabinetmedical.entity.Patient;
import ma.fsr.tp1.cabinetmedical.entity.RendezVous;
import ma.fsr.tp1.cabinetmedical.entity.Statu;
import ma.fsr.tp1.cabinetmedical.repository.MedecinRepo;
import ma.fsr.tp1.cabinetmedical.repository.PatientRepo;
import ma.fsr.tp1.cabinetmedical.repository.RendezVousRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RendezVousService {

    private final PatientRepo   patientRepo ;
    private final MedecinRepo medecinRepo ;
    private final  RendezVousRepo rendezVousRepo ;

    public RendezVousService(PatientRepo patientRepo, MedecinRepo medecinRepo, RendezVousRepo rendezVousRepo) {
        this.patientRepo = patientRepo;
        this.medecinRepo = medecinRepo;
        this.rendezVousRepo = rendezVousRepo;
    }

    public RendezVous addRendezVous(Long patientId , Long medecinId, LocalDate deteRdv ,Statu statu){
        Patient patient = patientRepo.findById(patientId).orElseThrow(
                ()-> new EntityNotFoundException("Patient not found")) ;
        Medecin medecin = medecinRepo.findById(medecinId).orElseThrow(
                ()-> new EntityNotFoundException("Medecin not found")) ;

        RendezVous rdv = new RendezVous();
        rdv.setPatient(patient);
        rdv.setMedecin(medecin);
        rdv.setDateRdv(deteRdv);
        rdv.setStatu(statu);

        return rendezVousRepo.save(rdv);

    }

    public List<RendezVous> getRdvByPatient(Long patientId){
        Patient patient = patientRepo.findById(patientId).orElseThrow(
                ()-> new EntityNotFoundException("Patient not found"));

        return rendezVousRepo.findRendezVousByPatient(patient) ;

    }

    public List<RendezVous> getRdvByMedecin(Long medecinId){
        Medecin  medecin = medecinRepo.findById(medecinId).orElseThrow(
                ()-> new EntityNotFoundException("Medecin not found"));

        return rendezVousRepo.findRendezVousByMedecin(medecin) ;

    }

    public List<RendezVous> getRdvBydate(LocalDate dateRdv){
        return rendezVousRepo.findRendezVousByDateRdv(dateRdv) ;

    }

    public List<RendezVous> getRdvByStatu(Statu statu){
        return rendezVousRepo.findRendezVousByStatu(statu) ;
    }



    }

