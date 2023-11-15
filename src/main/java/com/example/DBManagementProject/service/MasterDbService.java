package com.example.DBManagementProject.service;

import com.example.DBManagementProject.model.MasterDb;

import java.util.List;

public interface MasterDbService {
    List<MasterDb> getAllData();
    void addData(MasterDb masterDb);
    MasterDb getDataById(long id);
    void deleteDataById(long id);
}
