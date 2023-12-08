package CVDS.dina.proyecto.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CVDS.dina.proyecto.model.Plato;
import CVDS.dina.proyecto.repository.PlatoRepository;


@Service
public class PlatoService {
    private final PlatoRepository platoRepository;


    @Autowired
    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    public Plato addplato(Plato plato){return platoRepository.save(plato);}

    public void guardarPlato(Plato plato) {
        platoRepository.save(plato);
    }
}


