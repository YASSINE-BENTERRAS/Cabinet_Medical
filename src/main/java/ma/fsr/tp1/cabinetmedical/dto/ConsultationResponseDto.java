package ma.fsr.tp1.cabinetmedical.dto;

import java.time.LocalDate;

public record ConsultationResponseDto(String nomMedecin ,
                                      String nomPatient ,
                                      String rapport ,
                                      LocalDate dateConsultation) {
}
