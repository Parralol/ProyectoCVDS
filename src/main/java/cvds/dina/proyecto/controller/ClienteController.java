package cvds.dina.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cvds.dina.proyecto.model.Alergia;
import cvds.dina.proyecto.model.Cliente;
import cvds.dina.proyecto.service.AlergiaService;
import cvds.dina.proyecto.service.ClienteService;

@Controller
public class ClienteController {
    
    private Cliente cliente;
    private final String creacion = "creacion";

    ClienteService clienteService;

    AlergiaService alergiaService;

    @Autowired
    public ClienteController(ClienteService clienteService, AlergiaService alergiaService) {
        this.clienteService = clienteService;
        this.alergiaService = alergiaService;
    }
    @GetMapping("/prueba")
    public String cargarDatos(){
        return "menu";
    }
    @GetMapping("/crearcuenta")
    public String crearCuenta(){
        return creacion;
    }
    @PostMapping("/crearcuenta")
    public String asignarCuenta(String fname, String lname, String nickname,String pass, String comidaPreferida1, String comidaPreferida2, String comidaPreferida3, String tipoid, int cedula,@RequestParam("selectedAllergies") List<String> request, Model model){
        List<String> selectedList = new ArrayList<>();
        List<Alergia> allergies = new ArrayList<>();
        if (request.isEmpty()) {
            selectedList = null;
        }else{
            selectedList = request;
        }
        Cliente cliente = new Cliente(fname, lname);
        List<Cliente> clientes = clienteService.getAllClientes();
        for(Cliente a: clientes){
            if(a.getNickname().equals(nickname)){
                model.addAttribute("mensaje", "nombre de usuario existe");
                return creacion;
            }
        }
        cliente.setNickname(nickname);
        cliente.setPassword(pass);
        cliente.setComidaPreferidaUno(comidaPreferida1);
        cliente.setComidaPreferidaDos(comidaPreferida2);
        cliente.setComidaPreferidaTres(comidaPreferida3);
        cliente.setTipoId(tipoid);
        cliente.setCedula(cedula);
        cliente.setAlergias(allergies);
        cliente = clienteService.addCliente(cliente);
        this.cliente = cliente;
        if( selectedList != null){
            for(int i =0 ; i< selectedList.size(); i++ ){
                Alergia al = new Alergia(cliente, selectedList.get(i));
                allergies.add(al);
            }
            for(Alergia a: allergies){
                alergiaService.addAlergia(a);
            }
        }

        
        return "redirect:/confirm";
    }
    @GetMapping("/confirm")
    public String procesarFormulario( Model model) {
        
         model.addAttribute("cliente", cliente);
        return "confirmacion";
    }
    @GetMapping("/CrearCliente")
    public String subirDatos( ) {

        return "/principal1";
    }

    @GetMapping("/ComenzarCero")
    public String borrarDatos(){
        clienteService.deleteCliente(cliente.getClienteid());
        return creacion;
    }
}
