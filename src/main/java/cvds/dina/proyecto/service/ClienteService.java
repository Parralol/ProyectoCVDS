package cvds.dina.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cvds.dina.proyecto.model.Cliente;
import cvds.dina.proyecto.repository.ClienteRepository;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    
    public Cliente addCliente(Cliente Cliente) {
        return clienteRepository.save(Cliente);
    }
    
    public void save(List<Cliente> Cliente) {
        clienteRepository.saveAll(Cliente);
    }

    public Cliente getCliente(Long Clienteid) {
        if(clienteRepository.findByClienteid(Clienteid).size() != 0){
            return clienteRepository.findByClienteid(Clienteid).get(0);
        }else{
            return null;
        }
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente updateCliente(Cliente cliente) {
        if (clienteRepository.findByClienteid(cliente.getClienteid()).size() == 0) {
            return clienteRepository.save(cliente);
        }

        return null;
    }

    public void deleteCliente(Long Clienteid) {
        clienteRepository.deleteById(Clienteid);
    }
    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }
}
