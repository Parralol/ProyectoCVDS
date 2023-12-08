package CVDS.dina.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CVDS.dina.proyecto.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public List<Cliente> findByClienteid(Long id);

}
