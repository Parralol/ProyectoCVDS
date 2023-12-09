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
    
    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public void save(List<Cliente> cliente) {
        clienteRepository.saveAll(cliente);
    }

    public Cliente getCliente(Long clienteid) {
        if(!clienteRepository.findByClienteid(clienteid).isEmpty()){
            return clienteRepository.findByClienteid(clienteid).get(0);
        }else{
            return null;
        }
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente updateCliente(Cliente cliente) {
        if (clienteRepository.findByClienteid(cliente.getClienteid()).isEmpty()) {
            return clienteRepository.save(cliente);
        }

        return null;
    }

    public void deleteCliente(Long clienteid) {
        clienteRepository.deleteById(clienteid);
    }
    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }
}
