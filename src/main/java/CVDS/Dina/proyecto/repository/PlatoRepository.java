package CVDS.Dina.proyecto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import CVDS.Dina.proyecto.model.Plato;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {
    public List<Plato> findByNombre(String nombre);
}
