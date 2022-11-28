package com.example.proyectoFinal.controller;

import com.example.proyectoFinal.Entidad.Odontologo;
import com.example.proyectoFinal.Servicios.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/odontologos")
public class OdontologoController {
    private OdontologoService odontologoService;
    @Autowired
    public OdontologoController(OdontologoService odontologoService){

        this.odontologoService = odontologoService;
    }
    @PostMapping
    public ResponseEntity<Odontologo> addOdontologo(@RequestBody Odontologo odontologo){
        ResponseEntity response = null;
        if(odontologo!=null){
            response = new ResponseEntity<>(odontologoService.addOdontologo(odontologo),HttpStatus.CREATED);
        }else{
            response =  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologo(){
        ResponseEntity response = null;
        List<Odontologo> odontologos = odontologoService.listOdontologos();
        if (odontologos!=null){
            response = new ResponseEntity(odontologos, HttpStatus.OK);
        }else {
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Odontologo> deleteOdontologo(@PathVariable Long id){
        ResponseEntity response = null;
        if (odontologoService.searchOdontologo(id)!=null){
            odontologoService.deleteOdontologo(id);
            response = new ResponseEntity(HttpStatus.OK);
        }else {
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> searchOdontologo(@PathVariable Long id){
        ResponseEntity response = null;
        Odontologo odontologoBuscado = odontologoService.searchOdontologo(id).get();
        if (odontologoBuscado!= null){
            response = new ResponseEntity(odontologoBuscado,HttpStatus.OK);
        }else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return response;
    }
    @PutMapping
    public ResponseEntity<Odontologo> updateOdontologo(@RequestBody Odontologo odontologo){
        ResponseEntity response = null;
        Odontologo odontologoAModificar = odontologoService.searchOdontologo(odontologo.getId()).get();
        if (odontologoAModificar!=null){
            odontologoService.updateOdontologo(odontologo);
            response = new ResponseEntity<>(odontologo,HttpStatus.ACCEPTED);
        }else
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return response;
    }

}
