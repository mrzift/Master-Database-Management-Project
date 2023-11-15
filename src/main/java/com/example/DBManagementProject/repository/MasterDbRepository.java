package com.example.DBManagementProject.repository;

import com.example.DBManagementProject.model.MasterDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // - Indicates that an annotated class is used to retrieve and/or
            // manipulate data in a database
public interface MasterDbRepository extends JpaRepository <MasterDb,Long> {
}