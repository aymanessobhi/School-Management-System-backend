package com.shoolms.school;

import com.shoolms.school.models.*;
import com.shoolms.school.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SchoolApplication {

    public static void main(String[] args)
    {
        ApplicationContext context = SpringApplication.run(SchoolApplication.class, args);
       insertNationalities(context.getBean(NationalitieService.class));
       insertTypeBlood(context.getBean(TypeBloodService.class));
       insertReligion(context.getBean(ReligionService.class));
       insertSpecializations(context.getBean(SpecializationService.class));
       insertGenders(context.getBean(GenderService.class));

    }
    public static void insertSpecializations(SpecializationService specializationService) {
        Specialization[] specializations = {
                new Specialization(1L, "Mathematics"),
                new Specialization(2L, "Science"),
                new Specialization(3L, "History"),
                new Specialization(4L, "Literature"),
        };
        for (Specialization specialization : specializations) {
            specializationService.createSpecialization(specialization);
        }
    }
    public static void insertGenders(GenderService genderService) {
        Gender[] genders = {
                new Gender(1L, "Male"),
                new Gender(2L, "Female"),
        };
        for (Gender gender : genders) {
            genderService.saveGender(gender);
        }
    }
    private static void insertTypeBlood(TypeBloodService typeBloodService) {
        Type_Blood[] bloodTypes = {
                new Type_Blood(1L, "Type A+"),
                new Type_Blood(2L, "Type A-"),
                new Type_Blood(3L, "Type O-"),
                new Type_Blood(4L, "Type O+"),
                new Type_Blood(5L, "Type B+"),
                new Type_Blood(6L, "Type B-"),
                new Type_Blood(7L, "Type AB-"),
                new Type_Blood(8L, "Type AB+"),
        };
        for (Type_Blood bloodType : bloodTypes) {
            typeBloodService.saveTypeBlood(bloodType);
        }
    }
    public static void insertReligion(ReligionService religionService) {
        Religion[] religions = {
                new Religion(1L, "Christianity"),
                new Religion(2L, "Islam"),
                new Religion(3L, "Judaism"),
                new Religion(4L, "Other"),
                // Add more religions as needed
        };
        for (Religion religion : religions) {
            religionService.saveReligion(religion);
        }
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
}
