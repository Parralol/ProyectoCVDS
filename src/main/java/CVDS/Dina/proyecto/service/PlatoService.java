package CVDS.Dina.proyecto.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import CVDS.Dina.proyecto.model.Plato;
import CVDS.Dina.proyecto.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
