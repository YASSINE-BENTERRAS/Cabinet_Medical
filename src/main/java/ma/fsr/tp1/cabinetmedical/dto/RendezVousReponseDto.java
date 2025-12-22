package ma.fsr.tp1.cabinetmedical.dto;

import ma.fsr.tp1.cabinetmedical.entity.Statu;


import java.time.LocalDate;

public record RendezVousReponseDto(String nomPatient ,
                                   String nomMedecin ,
                                   LocalDate datRendezVous ,
                                   Statu statu) {
}
