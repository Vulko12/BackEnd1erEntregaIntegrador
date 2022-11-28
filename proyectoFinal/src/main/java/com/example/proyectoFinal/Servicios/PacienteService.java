package com.example.proyectoFinal.Servicios;
import com.example.proyectoFinal.Entidad.Paciente;
import com.example.proyectoFinal.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

  private PacienteRepository pacienteRepository;
@Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente agregar(Paciente paciente) {

    return pacienteRepository.save(paciente);
    }

    public List<Paciente> listar() {

       return pacienteRepository.findAll();
    }

    public void modificar(Paciente paciente) {

       pacienteRepository.save(paciente);
    }

    public void eliminar(Long id) {

        pacienteRepository.deleteById(id);
    }
    public Optional<Paciente> buscarPaciente(Long id ){

     return pacienteRepository.findById(id);

    }

}
