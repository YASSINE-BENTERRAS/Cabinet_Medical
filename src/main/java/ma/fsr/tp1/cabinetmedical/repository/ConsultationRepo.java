package ma.fsr.tp1.cabinetmedical.repository;

import ma.fsr.tp1.cabinetmedical.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {
}
