package ma.fsr.tp1.cabinetmedical.dto;

import java.time.LocalDate;

public record ConsultationRequestDto(Long patientId ,
                                     Long medecinId ,
                                     LocalDate dateConsultation ,
                                     String report
) {
}
