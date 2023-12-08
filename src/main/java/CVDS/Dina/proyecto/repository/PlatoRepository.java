package cvds.dina.proyecto.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cvds.dina.proyecto.model.Plato;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {
    public List<Plato> findBynombrePlato(String nombre);
}
