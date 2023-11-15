package com.example.DBManagementProject.service;

import com.example.DBManagementProject.model.MasterDb;
import com.example.DBManagementProject.repository.MasterDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Indicates that an annotated class has business logic


public class MasterDbServiceImpl implements MasterDbService{
    @Autowired // injecting MasterDb repository
    private MasterDbRepository masterDbRepository;

    @Override
    public List<MasterDb> getAllData() {
        return masterDbRepository.findAll(); //return list of employees to the controller.
    }

    @Override
    public void addData(MasterDb masterDb) {
        this.masterDbRepository.save(masterDb); // adds new data to the database.

    }
    @Override
    public MasterDb getDataById(long id) { // findById returns optional object
        Optional< MasterDb > optional = masterDbRepository.findById(id);
        MasterDb masterDb = null; // declaring masterdb object.
        if (optional.isPresent()) {
            masterDb = optional.get();
        } else {
            throw new RuntimeException(" Data not found for id :: " + id);
        }
        return masterDb;
    }

    @Override
    public void deleteDataById(long id) {
        this.masterDbRepository.deleteById(id);
    }
}
