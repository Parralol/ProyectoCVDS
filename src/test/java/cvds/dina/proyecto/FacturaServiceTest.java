package cvds.dina.proyecto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cvds.dina.proyecto.model.Factura;
import cvds.dina.proyecto.repository.FacturaRepository;
import cvds.dina.proyecto.service.FacturaService;

@SpringBootTest
public class FacturaServiceTest {
    @MockBean
    private FacturaRepository facturaRepository;

    @Test
    void testAddFactura() {
        FacturaService facturaService = new FacturaService(facturaRepository);

        Factura factura = new Factura(1L, 12000, "K1", LocalDate.now());


        when(facturaRepository.save(factura)).thenReturn(factura);

        Factura result = facturaService.addFactura(factura);


        verify(facturaRepository, times(1)).save(factura);


        assertEquals(factura, result);
    }

    @Test
    void testSaveFacturas() {
        FacturaService facturaService = new FacturaService(facturaRepository);

        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1L, 20000, "Harvies", LocalDate.now()));
        facturas.add(new Factura(2L, 40000, "K1", LocalDate.now()));

        when(facturaRepository.saveAll(facturas)).thenReturn(facturas);
        facturaService.save(facturas);

        verify(facturaRepository, times(1)).saveAll(facturas);
    }

    @Test
    void testGetFacturaFound() {

        FacturaService facturaService = new FacturaService(facturaRepository);
        Long facturaId = 1L;
        Factura factura = new Factura(facturaId, 20000, "harvies", LocalDate.now());
        when(facturaRepository.findByid(facturaId)).thenReturn(Collections.singletonList(factura));

        Factura result = facturaService.getFactura(facturaId);

        verify(facturaRepository, times(2)).findByid(facturaId);
        assertNotNull(result);
        assertEquals(factura, result);
    }

    @Test
    void testGetFacturaNotFound() {
        FacturaService facturaService = new FacturaService(facturaRepository);
        Long facturaId = 2L;
        when(facturaRepository.findByid(facturaId)).thenReturn(Collections.emptyList());
        Factura result = facturaService.getFactura(facturaId);
        verify(facturaRepository, times(1)).findByid(facturaId);
        assertNull(result);
    }

    @Test
    void testUpdateFacturaWhenNotExists() {
        FacturaService facturaService = new FacturaService(facturaRepository);

        Factura factura = new Factura(1L, 100000, "k1", LocalDate.now());
        when(facturaRepository.findByid(factura.getId())).thenReturn(new ArrayList<>());
        when(facturaRepository.save(factura)).thenReturn(factura);

        Factura result = facturaService.updateFactura(factura);
        verify(facturaRepository, times(1)).findByid(factura.getId());
        verify(facturaRepository, times(1)).save(factura);

        assertNotNull(result);
        assertEquals(factura, result);
    }

    @Test
    void testUpdateFacturaWhenExists() {
        FacturaService facturaService = new FacturaService(facturaRepository);
        Factura factura = new Factura(2L, 20000, "harvies", LocalDate.now());
        when(facturaRepository.findByid(factura.getId())).thenReturn(Collections.singletonList(factura));
        Factura result = facturaService.updateFactura(factura);
        verify(facturaRepository, times(1)).findByid(factura.getId());
        assertNull(result);
    }

    @Test
    void testDeleteFactura() {
        FacturaService facturaService = new FacturaService(facturaRepository);
        Long facturaIdToDelete = 1L;
        facturaService.deleteFactura(facturaIdToDelete);
        verify(facturaRepository, times(1)).deleteById(facturaIdToDelete);
    }

    @Test
    void testGetAllFacturas() {
        FacturaService facturaService = new FacturaService(facturaRepository);
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(2L, 20000, "harvies", LocalDate.now()));
        facturas.add(new Factura(1L, 50000, "k2", LocalDate.now()));
        when(facturaRepository.findAll()).thenReturn(facturas);
        List<Factura> result = facturaService.getAll();
        verify(facturaRepository, times(1)).findAll();
        assertEquals(facturas.size(), result.size());
    }
}
