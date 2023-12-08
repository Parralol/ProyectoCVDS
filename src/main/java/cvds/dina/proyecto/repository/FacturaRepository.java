package cvds.dina.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cvds.dina.proyecto.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
        public List<Factura> findByid(Long id);
}
