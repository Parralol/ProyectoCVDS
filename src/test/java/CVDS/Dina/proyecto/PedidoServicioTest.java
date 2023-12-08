package CVDS.dina.proyecto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import CVDS.dina.proyecto.model.Cliente;
import CVDS.dina.proyecto.model.Pedido;
import CVDS.dina.proyecto.repository.PedidoRepository;
import CVDS.dina.proyecto.service.PedidoService;

@SpringBootTest
public class PedidoServicioTest {
    @MockBean
    private PedidoRepository pedidoRepository;
    @Test
    public void testAddPedido() {
        PedidoService pedidoService = new PedidoService(pedidoRepository);
        Cliente cliente = new Cliente ("gabriel", "silva");
        Pedido pedido = new Pedido(1L,cliente,"Harvies","arroz" ,20000);
        when(pedidoRepository.save(pedido)).thenReturn(pedido);

        Pedido result = pedidoService.addPedido(pedido);
        verify(pedidoRepository, times(1)).save(pedido);
        assertEquals(pedido, result);
    }

    @Test
    public void testSavePedidos() {
        PedidoService pedidoService = new PedidoService(pedidoRepository);
        List<Pedido> pedidos = new ArrayList<>();
        Cliente cliente1 = new Cliente ("gabriel", "silva");
        Cliente cliente2 = new Cliente ("alejandro", "lozada");
        pedidos.add(new Pedido(1L,cliente1,"Harvies","arroz" ,20000));
        pedidos.add(new Pedido(2L,cliente2,"k1","pizza" ,20000));
        when(pedidoRepository.saveAll(pedidos)).thenReturn(pedidos);
        pedidoService.save(pedidos);
        verify(pedidoRepository, times(1)).saveAll(pedidos);
    }

    @Test
    public void testGetPedidoFound() {
        PedidoService pedidoService = new PedidoService(pedidoRepository);
        Cliente cliente = new Cliente ("ramon", "valdes");
        Long pedidoId = 1L;
        Pedido pedido = new Pedido(1L,cliente,"Harvies","arroz" ,20000);
        List<Pedido> found = new ArrayList<>();
        found.add(pedido);
        when(pedidoRepository.findByPedidoId(pedidoId)).thenReturn(found);
        Pedido result = pedidoService.getPedido(pedidoId);
        verify(pedidoRepository, times(2)).findByPedidoId(pedidoId);
        assertEquals(pedido, result);
    }

    @Test
    public void testGetPedidoNotFound() {
        PedidoService pedidoService = new PedidoService(pedidoRepository);

        Long pedidoId = 1L;

        when(pedidoRepository.findByPedidoId(pedidoId)).thenReturn(new ArrayList<>());

        Pedido result = pedidoService.getPedido(pedidoId);

        verify(pedidoRepository, times(1)).findByPedidoId(pedidoId);


        assertNull(result);
    }

    @Test
    public void testUpdatePedidoWhenFound() {
        PedidoService pedidoService = new PedidoService(pedidoRepository);
        Cliente cliente = new Cliente ("shahad", "lozada");
        Pedido pedido = new Pedido(1L,cliente,"k2","arroz y papas" ,34000);
        List<Pedido> found = new ArrayList<>();
        found.add(pedido);
        when(pedidoRepository.findByPedidoId(pedido.getpedidoId())).thenReturn(found);
        Pedido result = pedidoService.updatePedido(pedido);
        verify(pedidoRepository, times(1)).findByPedidoId(pedido.getpedidoId());
        verify(pedidoRepository, never()).save(pedido);
        assertNull(result);
    }

    @Test
    public void testDeletePedido() {
        PedidoService pedidoService = new PedidoService(pedidoRepository);
        Long pedidoIdToDelete = 1L; // ID del pedido a eliminar
        pedidoService.deletePedido(pedidoIdToDelete);
        verify(pedidoRepository, times(1)).deleteById(pedidoIdToDelete);
    }


}
