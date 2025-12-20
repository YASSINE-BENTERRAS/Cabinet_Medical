package ma.fsr.tp1.cabinetmedical.dto;

import java.time.LocalDate;

public record RendezVousRequestDto(Long patientId,
                                   Long medecinId ,
                                   LocalDate dateRdv) {
}
