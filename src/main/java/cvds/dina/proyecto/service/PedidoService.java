package cvds.dina.proyecto.service;
import java.util.List;

import org.springframework.stereotype.Service;

import cvds.dina.proyecto.model.Pedido;
import cvds.dina.proyecto.repository.PedidoRepository;

@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }
    
    public Pedido addPedido(Pedido Pedido) {
        return pedidoRepository.save(Pedido);
    }
    
    public void save(List<Pedido> Pedido) {
        pedidoRepository.saveAll(Pedido);
    }

    public Pedido getPedido(Long Pedidoid) {
        if(pedidoRepository.findByPedidoId(Pedidoid).size() != 0){
            return pedidoRepository.findByPedidoId(Pedidoid).get(0);
        }else{
            return null;
        }
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido updatePedido(Pedido Pedido) {
        if (pedidoRepository.findByPedidoId(Pedido.getpedidoId()).size() == 0) {
            return pedidoRepository.save(Pedido);
        }

        return null;
    }

    public void deletePedido(Long Pedidoid) {
        pedidoRepository.deleteById(Pedidoid);
    }
    public List<Pedido> getAll(){
        return pedidoRepository.findAll();
    }
}
