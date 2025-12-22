package ma.fsr.tp1.cabinetmedical.service;

import ma.fsr.tp1.cabinetmedical.entity.Patient;
import ma.fsr.tp1.cabinetmedical.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    PatientRepo  patientRepo;
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public List<Patient> getAll() {
        return patientRepo.findAll() ;
    }

    public Patient getPatientById(Long id){
        return patientRepo.findById(id).orElseThrow(()->
                new IllegalArgumentException("Patient n'existe pas"));
    }

    public List<Patient> searchPatientByNom(String nom){
        return patientRepo.findByName(nom);
    }

    //Création d'un Patient
    public Patient createPatient(Patient patient) throws Exception {
        if (patient.getName()==null || patient.getName().isBlank()) {
            throw new IllegalArgumentException("Nom obligatoire") ;
        }
        if (patient.getGenre()==null) {
            throw new IllegalArgumentException("Genre obligatoire") ;
        }
        if (patient.getDateNaissance()==null) {
            throw new IllegalArgumentException("la date de naissance est obligatoire") ;
        }
        return patientRepo.save(patient);
    }

    public Patient updatePatient(Patient patient) throws Exception {
        if (patient.getName()==null || patient.getName().isBlank()) {
            throw new IllegalArgumentException("Nom obligatoire") ;
        }
        if (patient.getGenre()==null) {
            throw new IllegalArgumentException("Genre obligatoire") ;
        }
        if (patient.getDateNaissance()==null) {
            throw new IllegalArgumentException("la date de naissance est obligatoire") ;
        }
        return patientRepo.save(patient);
    }
    public void deletePatient(Patient patient) throws IllegalAccessException {
        if (!patientRepo.existsById(patient.getId())) {
            throw new IllegalArgumentException("Le patient n'existe pas") ;
        }
         patientRepo.delete(patient);
    }

}
