package com.example.proyectoFinal.controller;


import com.example.proyectoFinal.Entidad.Odontologo;
import com.example.proyectoFinal.Entidad.Paciente;
import com.example.proyectoFinal.Servicios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService){

        this.pacienteService = pacienteService;

    }


    @PostMapping
    public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente){
        ResponseEntity response = null;
        if(paciente!=null){
            response = new ResponseEntity<>(pacienteService.agregar(paciente),HttpStatus.CREATED);
        }else{
            response =  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping
    public  ResponseEntity<List<Paciente>> listarPacientes(){
        ResponseEntity response = null;
    List<Paciente> pacientes = pacienteService.listar();
        if (pacientes!=null){
            response = new ResponseEntity(pacientes, HttpStatus.OK);
        }else {
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Paciente> updatePaciente(@RequestBody Paciente paciente){
        ResponseEntity response = null;
        Paciente pacienteAModificar = pacienteService.buscarPaciente(paciente.getId()).get();
        if (pacienteAModificar!=null){
            pacienteService.modificar(paciente);
            response = new ResponseEntity<>(paciente,HttpStatus.ACCEPTED);
        }else
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> deletePaciente(@PathVariable Long id){
        ResponseEntity response = null;
        if (pacienteService.buscarPaciente(id)!=null){
            pacienteService.eliminar(id);
            response = new ResponseEntity(HttpStatus.OK);
        }else {
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> searchPaciente(@PathVariable Long id){
        ResponseEntity response = null;
        Paciente pacienteBuscado = pacienteService.buscarPaciente(id).get();
        if (pacienteBuscado!= null){
            response = new ResponseEntity(pacienteBuscado,HttpStatus.OK);
        }else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return response;
    }


    }






