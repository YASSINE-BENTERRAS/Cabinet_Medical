package ma.fsr.tp1.cabinetmedical.repository;

import ma.fsr.tp1.cabinetmedical.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinRepo extends JpaRepository<Medecin,Long> {
    List<Medecin> findByNom(String nom);
}
