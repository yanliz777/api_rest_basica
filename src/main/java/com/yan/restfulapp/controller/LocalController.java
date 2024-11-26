package com.yan.restfulapp.controller;

import com.yan.restfulapp.entity.Local;
import com.yan.restfulapp.service.interfaces.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {

    //inyectamos nuestro servicio:
    @Autowired
    LocalService localService;

    @GetMapping("/findALLocals")
    public List<Local> findALLocals(){
        return localService.findAllLocals();
    }

    @PostMapping("/saveLocal")
    //Con @RequestBody Local local, indicamos el Body que envia el cliente en la petición
    public Local saveLocal(@RequestBody Local local){
        localService.saveLocal(local);
        return local;
    }

    @PutMapping("/updateLocal/{id}")
    public Local updateLocal(@PathVariable Long id, @RequestBody Local local){
        return localService.updateLocal(id,local);
    }

    @DeleteMapping("/deleteLocal/{id}")
    public String deleteLocal(@PathVariable Long id){
        localService.deleteLocal(id);
        return "Deleted local with id: " + id + " was successfully deleted";
    }

    @GetMapping("/findLocalByNameWithJPQL/{name}")
    public Optional<Local> findLocalByNameWithJPQL(@PathVariable String name){
        return localService.findLocalByNameWithJPQL(name);
    }

    @GetMapping("/findLocalByName/{name}")
    public Optional<Local> findByNameLocal(@PathVariable String name){
        return localService.findByNameLocal(name);
    }

}

