package com.example.proyectoFinal.Servicios;
import com.example.proyectoFinal.Entidad.Odontologo;
import com.example.proyectoFinal.Servicios.OdontologoService;
import com.example.proyectoFinal.Repository.OdontologoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class OdontologoService {

    private OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo addOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public void updateOdontologo(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> searchOdontologo(Long id){
        return odontologoRepository.findById(id);
    }

    public List<Odontologo> listOdontologos(){
        return odontologoRepository.findAll();
    }

    public void deleteOdontologo(Long id){
        odontologoRepository.deleteById(id);
    }

}