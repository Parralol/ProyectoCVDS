package cvds.dina.proyecto.service;
import org.springframework.stereotype.Service;

import cvds.dina.proyecto.model.Plato;
import cvds.dina.proyecto.repository.PlatoRepository;


@Service
public class PlatoService {
    private final PlatoRepository platoRepository;

    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    public Plato addplato(Plato plato){return platoRepository.save(plato);}

    public void guardarPlato(Plato plato) {
        platoRepository.save(plato);
    }
}


