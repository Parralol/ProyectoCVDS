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
    
    public Pedido addPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    
    public void save(List<Pedido> pedido) {
        pedidoRepository.saveAll(pedido);
    }

    public Pedido getPedido(Long pedidoid) {
        if(pedidoRepository.findByPedidoId(pedidoid).isEmpty()){
            return pedidoRepository.findByPedidoId(pedidoid).get(0);
        }else{
            return null;
        }
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido updatePedido(Pedido pedido) {
        if (pedidoRepository.findByPedidoId(pedido.getpedidoId()).isEmpty()) {
            return pedidoRepository.save(pedido);
        }

        return null;
    }

    public void deletePedido(Long pedidoid) {
        pedidoRepository.deleteById(pedidoid);
    }
    public List<Pedido> getAll(){
        return pedidoRepository.findAll();
    }
}
