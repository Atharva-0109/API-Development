package com.example.API.Development.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo)
    {
        return args ->
        {
            StudentData atharvaDeshmukh = new StudentData(
                    "atharvad402@gmail.com",
                    "Atharva Deshmukh",
                    LocalDate.of(2000, SEPTEMBER, 1)


            );

            StudentData alex = new StudentData(
                    "alex@gmail.com",
                    "alex",
                    LocalDate.of(2005, JANUARY, 5)


            );

            studentRepo.saveAll(
                    Arrays.asList(atharvaDeshmukh,alex)
            );
        };
    }
}
