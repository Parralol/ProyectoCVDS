package CVDS.Dina.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import CVDS.Dina.proyecto.model.Cliente;
import CVDS.Dina.proyecto.service.ClienteService;

@Controller
public class login {

    private Cliente cliente;

    @Autowired
    ClienteService clienteService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //prueba
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
