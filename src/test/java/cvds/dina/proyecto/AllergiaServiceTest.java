package cvds.dina.proyecto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cvds.dina.proyecto.model.Alergia;
import cvds.dina.proyecto.model.Cliente;
import cvds.dina.proyecto.repository.AlergiaRepository;
import cvds.dina.proyecto.service.AlergiaService;


@SpringBootTest
class AllergiaServiceTest {
    @MockBean
    private AlergiaRepository alergiaRepository;

    @Test
    void testAddAlergia() {
        AlergiaService alergiaService = new AlergiaService(alergiaRepository);

        Cliente cliente = new Cliente();
        cliente.setClienteid(1L);


        Alergia alergia = new Alergia(cliente, "Alergia de prueba");


        when(alergiaRepository.save(alergia)).thenReturn(alergia);

        Alergia result = alergiaService.addAlergia(alergia);


        verify(alergiaRepository, times(1)).save(alergia);


        assertEquals(alergia, result);
    }

    @Test
    void testSave() {
        AlergiaService alergiaService = new AlergiaService(alergiaRepository);

        List<Alergia> alergias = new ArrayList<>();

        when(alergiaRepository.saveAll(alergias)).thenReturn(alergias);
        alergiaService.save(alergias);
        verify(alergiaRepository, times(1)).saveAll(alergias);
    }

    @Test
    void testGetAlergiaFound() {
        AlergiaService alergiaService = new AlergiaService(alergiaRepository);

        Long alergiaId = 1L;


        Alergia alergia = new Alergia();
        alergia.setAlergiasid(alergiaId);
        alergia.setName("Alergia de prueba");


        when(alergiaRepository.findByAlergiasid(alergiaId)).thenReturn(List.of(alergia));

        Alergia result = alergiaService.getAlergia(alergiaId);


        verify(alergiaRepository, times(2)).findByAlergiasid(alergiaId);


        assertEquals(alergia, result);
    }

    @Test
    void testGetAlergiaNotFound() {
        AlergiaService alergiaService = new AlergiaService(alergiaRepository);

        Long alergiaId = 2L;


        when(alergiaRepository.findByAlergiasid(alergiaId)).thenReturn(new ArrayList<>());

        Alergia result = alergiaService.getAlergia(alergiaId);

        verify(alergiaRepository, times(1)).findByAlergiasid(alergiaId);


        assertNull(result);
    }

    @Test
    void testUpdateAlergiaNewAlergia() {
        AlergiaService alergiaService = new AlergiaService(alergiaRepository);


        Alergia alergia = new Alergia();
        alergia.setAlergiasid(1L);


        when(alergiaRepository.findByAlergiasid(alergia.getAlergiasid())).thenReturn(new ArrayList<>());


        when(alergiaRepository.save(alergia)).thenReturn(alergia);

        Alergia result = alergiaService.updateAlergia(alergia);


        verify(alergiaRepository, times(1)).findByAlergiasid(alergia.getAlergiasid());


        assertEquals(alergia, result);
    }

    @Test
    void testUpdateAlergiaExistingAlergia() {
        AlergiaService alergiaService = new AlergiaService(alergiaRepository);


        Alergia alergia = new Alergia();
        alergia.setAlergiasid(1L);


        when(alergiaRepository.findByAlergiasid(alergia.getAlergiasid())).thenReturn(List.of(alergia));

        Alergia result = alergiaService.updateAlergia(alergia);


        verify(alergiaRepository, times(1)).findByAlergiasid(alergia.getAlergiasid());

        assertNull(result);
    }

    @Test
    void testDeleteAlergia() {
        AlergiaService alergiaService = new AlergiaService(alergiaRepository);

        Long alergiaId = 1L;

        alergiaService.deleteAlergia(alergiaId);


        verify(alergiaRepository, times(1)).deleteById(alergiaId);
    }

    @Test
    void testGetAll() {
        AlergiaService alergiaService = new AlergiaService(alergiaRepository);


        List<Alergia> alergias = new ArrayList<>();
        alergias.add(new Alergia());
        alergias.add(new Alergia());
        when(alergiaRepository.findAll()).thenReturn(alergias);

        List<Alergia> result = alergiaService.getAll();


        verify(alergiaRepository, times(1)).findAll();


        assertEquals(alergias.size(), result.size());
    }

    @Test
    void testGetAllById() {
        AlergiaService alergiaService = new AlergiaService(alergiaRepository);

        ArrayList<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);


        List<Alergia> alergias = new ArrayList<>();
        alergias.add(new Alergia());
        alergias.add(new Alergia());
        when(alergiaRepository.findAllById(ids)).thenReturn(alergias);

        List<Alergia> result = alergiaService.getAllById(ids);


        verify(alergiaRepository, times(1)).findAllById(ids);

        assertEquals(alergias.size(), result.size());
    }
}
