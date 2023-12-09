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
    
    public Factura addFactura(Factura Factura) {
        return facturaRepository.save(Factura);
    }
    
    public void save(List<Factura> Factura) {
        facturaRepository.saveAll(Factura);
    }

    public Factura getFactura(Long Facturaid) {
        if(facturaRepository.findByid(Facturaid).size() != 0){
            return facturaRepository.findByid(Facturaid).get(0);
        }else{
            return null;
        }
    }

    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    public Factura updateFactura(Factura Factura) {
        if (facturaRepository.findByid(Factura.getId()).size() == 0) {
            return facturaRepository.save(Factura);
        }

        return null;
    }

    public void deleteFactura(Long Facturaid) {
        facturaRepository.deleteById(Facturaid);
    }
    public List<Factura> getAll(){
        return facturaRepository.findAll();
    }
}
