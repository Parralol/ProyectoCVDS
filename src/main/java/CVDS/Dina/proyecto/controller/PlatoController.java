package CVDS.dina.proyecto.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import CVDS.dina.proyecto.model.Plato;
import CVDS.dina.proyecto.service.PlatoService;

@Controller
public class PlatoController {
    private final PlatoService platoService;

    // Constructor con inyección de dependencias de PlatoService
    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @PostMapping("/guardar-plato") // Ruta para guardar múltiples platos
    public ResponseEntity<String> guardarPlatos(@RequestBody List<Plato> platos) {
        // Iterar sobre la lista de platos y guardar cada uno en la base de datos
        for (Plato plato : platos) {
            platoService.guardarPlato(plato);
        }

        return ResponseEntity.ok("Platos guardados correctamente"); // Respuesta exitosa
    }
}
