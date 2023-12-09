package cvds.dina.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cvds.dina.proyecto.model.Factura;
import cvds.dina.proyecto.repository.FacturaRepository;

@Service
public class FacturaService {
    private FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository){
        this.facturaRepository = facturaRepository;
    }
    
    public Factura addFactura(Factura factura) {
        return facturaRepository.save(factura);
    }
    
    public void save(List<Factura> factura) {
        facturaRepository.saveAll(factura);
    }

    public Factura getFactura(Long facturaid) {
        if(!facturaRepository.findByid(facturaid).isEmpty()){
            return facturaRepository.findByid(facturaid).get(0);
        }else{
            return null;
        }
    }

    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    public Factura updateFactura(Factura factura) {
        if (facturaRepository.findByid(factura.getId()).isEmpty()) {
            return facturaRepository.save(factura);
        }

        return null;
    }

    public void deleteFactura(Long facturaid) {
        facturaRepository.deleteById(facturaid);
    }
    public List<Factura> getAll(){
        return facturaRepository.findAll();
    }
}
