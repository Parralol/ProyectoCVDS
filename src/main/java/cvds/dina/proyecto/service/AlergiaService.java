package cvds.dina.proyecto.service;

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
    
    public Alergia addAlergia(Alergia alergia) {
        return alergiaRepository.save(alergia);
    }
    
    public void save(List<Alergia> alergia) {
        alergiaRepository.saveAll(alergia);
    }

    public Alergia getAlergia(Long alergiaid) {
        if(alergiaRepository.findByAlergiasid(alergiaid).isEmpty()){
            return alergiaRepository.findByAlergiasid(alergiaid).get(0);
        }else{
            return null;
        }
    }

    public List<Alergia> getAllAlergias() {
        return alergiaRepository.findAll();
    }

    public Alergia updateAlergia(Alergia alergia) {
        if (alergiaRepository.findByAlergiasid(alergia.getAlergiasid()).isEmpty()) {
            return alergiaRepository.save(alergia);
        }

        return null;
    }

    public void deleteAlergia(Long alergiaid) {
        alergiaRepository.deleteById(alergiaid);
    }
    public List<Alergia> getAll(){
        return alergiaRepository.findAll();
    }
    public List<Alergia> getAllById(List<Long> id){
        return alergiaRepository.findAllById(id);
    }

}
