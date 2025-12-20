package ma.fsr.tp1.cabinetmedical.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private LocalDate dateConsultation;
    private String rapport ;

    @OneToOne
    @JoinColumn(name = "rendezVous_id")
    private RendezVous rendezVous ;

    public Consultation(LocalDate dateConsultation, String rapport, RendezVous rendezVous) {
        this.dateConsultation = dateConsultation;
        this.rapport = rapport;
        this.rendezVous = rendezVous;
    }
}
