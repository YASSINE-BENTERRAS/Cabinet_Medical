package ma.fsr.tp1.cabinetmedical;

import ma.fsr.tp1.cabinetmedical.entity.*;
import ma.fsr.tp1.cabinetmedical.repository.MedecinRepo;
import ma.fsr.tp1.cabinetmedical.repository.PatientRepo;
import ma.fsr.tp1.cabinetmedical.repository.RendezVousRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class CabinetMedicalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CabinetMedicalApplication.class, args);
    }

    // Initialisation des données avec injection des repositories
    @Bean
    CommandLineRunner initDB(PatientRepo patientRepo, MedecinRepo medecinRepo, RendezVousRepo rendezVousRepo) {
        Patient patient1 = new Patient(
                "Hicham",
                LocalDate.of(2002, 12, 1),
                Genre.Homme,
                "+212567453423"
        );

        Medecin medecin1 = new Medecin(
                "Karim",
                "Cardiologie",
                "karim@gmail.com"
        ) ;

        return args -> {
            // Patients
            patientRepo.save(new Patient(
                    "Yassine",
                    LocalDate.of(2004, 10, 1),
                    Genre.Homme,
                    "+212567453423"
            ));
            patientRepo.save(patient1);

            // Médecins
            medecinRepo.save(medecin1);

            medecinRepo.save(new Medecin(
                    "Reda",
                    "Cardiologie",
                    "reda@gmail.com"
            ));

            rendezVousRepo.save(new RendezVous( LocalDate.of(2025,12,18),
                                                Statu.Planifie,
                                                patient1,
                                                medecin1)) ;
        };
    }
}
