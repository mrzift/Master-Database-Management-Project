package com.example.DBManagementProject.controller;

import com.example.DBManagementProject.model.MasterDb;
import com.example.DBManagementProject.service.MasterDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller // Indicates that an annotated class is a "Controller"
public class MasterDbController {

    @Autowired
    private MasterDbService masterDbService;

    // display list of employees
    @GetMapping("/home")
    public String viewHomePage(Model model) {
        model.addAttribute("listData", masterDbService.getAllData());
        return "index";
    }


    @GetMapping("/showNewDataForm") // addNewData handler. takes care of adding new entries.
    public String showNewDataForm(Model model) {
        // create model attribute to bind form data
        MasterDb masterDb = new MasterDb();
        model.addAttribute("masterdb", masterDb);
        return "newdataform";
    }


    @PostMapping("/saveData") // method handler to save data
    public String saveData(@ModelAttribute("masterdb") MasterDb masterDb) {
        // save employee to database
        masterDbService.addData(masterDb);
        return "redirect:/home";  // redirecting to the homepage.
    }


    @GetMapping("/showFormForUpdate/{id}")// In this case, {id} represents the placeholder for
    // the actual value that will be provided dynamically. When the URL is generated and rendered,
    // the value of master_db.id will be substituted for {id} in the URL.
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get masterdb from the service
        MasterDb masterDb = masterDbService.getDataById(id);

        // set masterdb as a model attribute to pre-populate the form. (info is available in the form pre-hand to edit)
        model.addAttribute("masterdb", masterDb);
        return "updatedatabase";
    }

    @GetMapping("/deleteData/{id}")
    public String deleteData(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.masterDbService.deleteDataById(id);
        return "redirect:/home";
    }
}
