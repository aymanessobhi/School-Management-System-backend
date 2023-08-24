package com.shoolms.school;

import com.shoolms.school.models.Nationalitie;
import com.shoolms.school.service.NationalitieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SchoolApplication {

    public static void main(String[] args)
    {
        ApplicationContext context = SpringApplication.run(SchoolApplication.class, args);
       insertNationalities(context.getBean(NationalitieService.class));
    }

    private static void insertNationalities(NationalitieService nationalitieService){
        Nationalitie[] nationalities = {
                new Nationalitie(1L, "France"),
                new Nationalitie(2L, "Germany"),
                new Nationalitie(3L, "United Kingdom"),
                new Nationalitie(4L, "Spain"),
                new Nationalitie(5L, "Egypt"),
                new Nationalitie(6L, "Nigeria"),
                new Nationalitie(7L, "South Africa"),
                new Nationalitie(8L, "Kenya"),
                new Nationalitie(9L, "Morocco"),
                new Nationalitie(10L, "Ethiopia"),
                new Nationalitie(11L, "Ghana"),
                new Nationalitie(12L, "Algeria"),
                new Nationalitie(13L, "Tanzania"),
                new Nationalitie(14L, "Uganda"),
                new Nationalitie(15L, "Sudan"),
                new Nationalitie(16L, "Angola"),
                new Nationalitie(17L, "Zambia"),
                new Nationalitie(18L, "Mozambique"),
                new Nationalitie(19L, "Ivory Coast (Côte d'Ivoire)")
        };
        for (Nationalitie nationality : nationalities) {
            nationalitieService.saveNationalitie(nationality);
        }
    }
    public static void insertReligion(){


    }
}
