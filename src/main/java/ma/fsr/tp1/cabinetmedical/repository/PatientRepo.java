package ma.fsr.tp1.cabinetmedical.repository;

import ma.fsr.tp1.cabinetmedical.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    List<Patient> findByName(String nom);
}
