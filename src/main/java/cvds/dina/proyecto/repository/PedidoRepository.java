package cvds.dina.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cvds.dina.proyecto.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    public List<Pedido> findByPedidoId(Long id);
}
