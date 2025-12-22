package ma.fsr.tp1.cabinetmedical.service;

import ma.fsr.tp1.cabinetmedical.dto.ConsultationRequestDto;
import ma.fsr.tp1.cabinetmedical.entity.Consultation;
import ma.fsr.tp1.cabinetmedical.entity.Medecin;
import ma.fsr.tp1.cabinetmedical.entity.Patient;
import ma.fsr.tp1.cabinetmedical.entity.RendezVous;
import ma.fsr.tp1.cabinetmedical.repository.ConsultationRepo;
import ma.fsr.tp1.cabinetmedical.repository.MedecinRepo;
import ma.fsr.tp1.cabinetmedical.repository.PatientRepo;
import ma.fsr.tp1.cabinetmedical.repository.RendezVousRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ConsultationService {
    private final ConsultationRepo consultationRepo ;
    private  final PatientRepo patientRepo ;
    private final MedecinRepo medecinRepo ;
    private final RendezVousRepo rendezVousRepo ;

    public ConsultationService(ConsultationRepo consultationRepo, PatientRepo patientRepo, MedecinRepo medecinRepo ,RendezVousRepo rendezVousRepo) {
        this.consultationRepo = consultationRepo;
        this.patientRepo = patientRepo;
        this.medecinRepo = medecinRepo;
        this.rendezVousRepo = rendezVousRepo;
    }

    public Consultation createConsultation(ConsultationRequestDto requestDto){
        Patient patient = patientRepo.findById(requestDto.patientId()).orElseThrow(null);
        Medecin medecin = medecinRepo.findById(requestDto.medecinId()).orElseThrow(null);
        RendezVous rendezVous = rendezVousRepo.findRendezVousByPatientAndMedecin(patient,medecin) ;

        return consultationRepo.save(new Consultation(
                requestDto.dateConsultation(),
                requestDto.report(),
                rendezVous)) ;
    }

    public Consultation searchById(Long id){
        return consultationRepo.findById(id).orElseThrow(null);
    }

    public List<Consultation> getAll(){
        return consultationRepo.findAll();
    }




}
