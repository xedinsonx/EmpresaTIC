package com.colmena.EmpresaTIC.Controller;

import com.colmena.EmpresaTIC.Model.Empresa;
import com.colmena.EmpresaTIC.Repo.EmpresaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaRepo empresaRepo;
    @GetMapping("/getAllEmpresas")
    public ResponseEntity<List<Empresa>> getAllEmpresas(){
        try {
            List<Empresa> empresaList = new ArrayList<>();
            empresaRepo.findAll().forEach(empresaList::add);

            if (empresaList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(empresaList, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/getEmpresasById/{id}")
    public ResponseEntity<Empresa> getEmpresasById(@PathVariable Long id){
        Optional<Empresa> empresaData =empresaRepo.findById(id);

        if(empresaData.isPresent()){
            return new ResponseEntity<>(empresaData.get(), HttpStatus.OK);

        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/addEmpresas")
    public ResponseEntity<Empresa>addEmpresas(@RequestBody Empresa empresa) {
        Empresa empresaObj = empresaRepo.save(empresa);

        return new ResponseEntity<>(empresaObj, HttpStatus.OK);

    }

}
