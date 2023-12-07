package CVDS.Dina.proyecto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import CVDS.Dina.proyecto.model.Cliente;
import CVDS.Dina.proyecto.repository.ClienteRepository;
import CVDS.Dina.proyecto.service.ClienteService;



@SpringBootTest
public class ClienteServiceTest {
    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    public void testAddClienteWithAllAttributes() {
        ClienteService clienteService = new ClienteService(clienteRepository);


        Cliente cliente = new Cliente("John", "Doe");
        cliente.setNickname("john_doe");
        cliente.setPassword("pass123");
        cliente.setFirstName("jhone");
        cliente.setLastName("Doe");
        cliente.setComidaPreferidaUno("arroz");
        cliente.setComidaPreferidaDos("papa");
        cliente.setComidaPreferidaTres("frijol");
        cliente.setFuturasComidas("platano");
        cliente.setCedula(123242);
        cliente.setTipoId("24A");

        when(clienteRepository.save(cliente)).thenReturn(cliente);
        Cliente result = clienteService.addCliente(cliente);


        verify(clienteRepository, times(1)).save(cliente);

        assertEquals(cliente, result);
    }

    @Test
    public void testSaveAllClientes() {
        ClienteService clienteService = new ClienteService(clienteRepository);


        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("John", "Doe"));
        clientes.add(new Cliente("Alice", "Smith"));
        clientes.add(new Cliente ("gabriel", "silva"));

        when(clienteRepository.saveAll(clientes)).thenReturn(clientes);

        clienteService.save(clientes);

        verify(clienteRepository, times(1)).saveAll(clientes);
    }
    @Test
    public void testGetClienteFound() {
        ClienteService clienteService = new ClienteService(clienteRepository);
        Long clienteId = 1L;

        Cliente cliente = new Cliente("John", "Doe");
        cliente.setClienteid(clienteId);

        when(clienteRepository.findByClienteid(clienteId)).thenReturn(List.of(cliente));
        Cliente result = clienteService.getCliente(clienteId);

        verify(clienteRepository, times(2)).findByClienteid(clienteId);

        assertEquals(cliente, result);
    }

    @Test
    public void testGetClienteNotFound() {
        ClienteService clienteService = new ClienteService(clienteRepository);

        Long clienteId = 2L;
        when(clienteRepository.findByClienteid(clienteId)).thenReturn(new ArrayList<>());

        Cliente result = clienteService.getCliente(clienteId);

        verify(clienteRepository, times(1)).findByClienteid(clienteId);

        assertNull(result);
    }

    @Test
    public void testGetAllClientes() {
        ClienteService clienteService = new ClienteService(clienteRepository);


        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("John", "Doe"));
        clientes.add(new Cliente("Alice", "Smith"));
        clientes.add(new Cliente("gabriel", "silva"));

        when(clienteRepository.findAll()).thenReturn(clientes);
        List<Cliente> result = clienteService.getAllClientes();

        verify(clienteRepository, times(1)).findAll();

        assertEquals(clientes.size(), result.size());
    }


    @Test
    public void testUpdateClienteWhenNotExists() {
        ClienteService clienteService = new ClienteService(clienteRepository);

        Cliente cliente = new Cliente("John", "Doe");
        cliente.setClienteid(1L);


        when(clienteRepository.findByClienteid(cliente.getClienteid())).thenReturn(new ArrayList<>());
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.updateCliente(cliente);


        verify(clienteRepository, times(1)).findByClienteid(cliente.getClienteid());


        assertNotNull(result);
        assertEquals(cliente, result);
    }

    @Test
    public void testUpdateClienteWhenExists() {
        ClienteService clienteService = new ClienteService(clienteRepository);


        Cliente cliente = new Cliente("Alice", "Smith");
        cliente.setClienteid(2L);


        when(clienteRepository.findByClienteid(cliente.getClienteid())).thenReturn(List.of(cliente));

        Cliente result = clienteService.updateCliente(cliente);


        verify(clienteRepository, times(1)).findByClienteid(cliente.getClienteid());

        assertNull(result);
    }

    @Test
    public void testDeleteCliente() {
        ClienteService clienteService = new ClienteService(clienteRepository);

        Long clienteIdToDelete = 1L;
        doNothing().when(clienteRepository).deleteById(clienteIdToDelete);

        clienteService.deleteCliente(clienteIdToDelete);

        verify(clienteRepository, times(1)).deleteById(clienteIdToDelete);
    }

    @Test
    public void testGetAll() {
        ClienteService clienteService = new ClienteService(clienteRepository);


        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("John", "Doe"));
        clientes.add(new Cliente("Alice", "Smith"));
        clientes.add(new Cliente("gabriel", "silva"));

        when(clienteRepository.findAll()).thenReturn(clientes);
        List<Cliente> result = clienteService.getAll();

        verify(clienteRepository, times(1)).findAll();
        assertEquals(clientes.size(), result.size());
    }



}
