package com.example.API.Development.student;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<StudentData,Long> {

    @Query("Select s FROM StudentData s WHERE s.email=?1")
    Optional<StudentData> findStudentDataByEmail(String email);
}
