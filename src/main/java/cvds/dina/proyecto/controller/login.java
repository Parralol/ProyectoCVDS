package cvds.dina.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cvds.dina.proyecto.model.Cliente;
import cvds.dina.proyecto.service.ClienteService;

@Controller
public class Login {

    private Cliente cliente;

    @Autowired
    public Login(Cliente cliente){
        this.cliente = cliente;
    }
    ClienteService clienteService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
         boolean usern = false;
        List<Cliente> clientes = clienteService.getAllClientes();
        for(Cliente a : clientes){
            if (a.getNickname().equals(username) && a.getPassword().equals(password)) {
                cliente = a;
                usern = true;
            }
        }
        if(usern){
            model.addAttribute("cliente", cliente);
            return "redirect:/lunch";
        }else{
            model.addAttribute("mensaje", "Usuario o contraseña incorrectos");
            return "login";
        }
            
        
    }
    @GetMapping("/lunch")
    public String lunch() {
        return "lunch";
    }
}
