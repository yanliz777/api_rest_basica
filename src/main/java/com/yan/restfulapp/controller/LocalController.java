package com.yan.restfulapp.controller;

import com.yan.restfulapp.entity.Local;
import com.yan.restfulapp.error.LocalNotFoundException;
import com.yan.restfulapp.service.interfaces.LocalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {

    //inyectamos nuestro servicio:
    @Autowired
    LocalService localService;

    @GetMapping("/findLocalById/{id}")
    public Local findLocalById(@PathVariable Long id)throws LocalNotFoundException {
        return localService.findLocalById(id);
    }

    @GetMapping("/findALLocals")
    public List<Local> findALLocals(){
        return localService.findAllLocals();
    }

    @PostMapping("/saveLocal")
    /*
    Con @RequestBody Local local, indicamos el Body que envia el cliente en la petición.
    con @Valid indicamos que en este endpoint vamos a validar el Local que se resgistra en la BD
     */
    public Local saveLocal(@Valid @RequestBody Local local){
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

    @GetMapping("/findByNameIgnoreCase/{name}")
    public  Optional<Local> findByNameIgnoreCase(@PathVariable String name){
        return localService.findByNameIgnoreCase(name);
    }

}

