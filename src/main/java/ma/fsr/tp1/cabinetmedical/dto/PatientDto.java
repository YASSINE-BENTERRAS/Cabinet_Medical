package ma.fsr.tp1.cabinetmedical.dto;

import ma.fsr.tp1.cabinetmedical.entity.Genre;

import java.time.LocalDate;

public record PatientDto(String name , LocalDate dateNaissance , Genre genre , String telepone) {
}
