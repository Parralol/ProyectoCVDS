package cvds.dina.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cvds.dina.proyecto.model.Alergia;
import cvds.dina.proyecto.repository.AlergiaRepository;

@Service
public class AlergiaService {

    private AlergiaRepository alergiaRepository;

    public AlergiaService(AlergiaRepository alergiaRepository){
        this.alergiaRepository = alergiaRepository;
    }
    
    public Alergia addAlergia(Alergia Alergia) {
        return alergiaRepository.save(Alergia);
    }
    
    public void save(List<Alergia> Alergia) {
        alergiaRepository.saveAll(Alergia);
    }

    public Alergia getAlergia(Long Alergiaid) {
        if(alergiaRepository.findByAlergiasid(Alergiaid).size() != 0){
            return alergiaRepository.findByAlergiasid(Alergiaid).get(0);
        }else{
            return null;
        }
    }

    public List<Alergia> getAllAlergias() {
        return alergiaRepository.findAll();
    }

    public Alergia updateAlergia(Alergia Alergia) {
        if (alergiaRepository.findByAlergiasid(Alergia.getAlergiasid()).size() == 0) {
            return alergiaRepository.save(Alergia);
        }

        return null;
    }

    public void deleteAlergia(Long Alergiaid) {
        alergiaRepository.deleteById(Alergiaid);
    }
    public List<Alergia> getAll(){
        return alergiaRepository.findAll();
    }
    public List<Alergia> getAllById(ArrayList<Long> id){
        return alergiaRepository.findAllById(id);
    }

}
