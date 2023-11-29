package CVDS.Dina.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("/login")
    public String login(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return "redirect:/lunch";
        } else {
            return "login";
        }
    }
    @RequestMapping("/lunch")
    public String lunch() {
        return "lunch";
    }
}
