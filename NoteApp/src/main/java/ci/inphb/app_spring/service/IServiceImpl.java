package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Service;
import ci.inphb.app_spring.exception.ServicesNotFoundException;
import ci.inphb.app_spring.repositories.ServiceRepository;
import ci.inphb.app_spring.repositories.SousDirectionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Slf4j
@Transactional
@AllArgsConstructor
public class IServiceImpl implements IService {

    private ServiceRepository serviceRepository;
    private SousDirectionRepository sousDirectionRepository;

    @Override
    public Service saveService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service getServiceById(Long idService) {
        return serviceRepository.findById(idService).orElseThrow(()-> new ServicesNotFoundException("Service not found !!!"));
    }

    @Override
    public List<Service> getAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public void deleteService(Long idService) {
        serviceRepository.deleteById(idService);
    }

    @Override
    public Service updateService(Long idService, Service service) {
        Service _service = this.getServiceById(idService);
        _service.setLibelle(service.getLibelle());
        return _service;
    }

    @Override
    public Service getServiceByName(String libelleService) {
        return serviceRepository.findByLibelle(libelleService);
    }

    @Override
    public void affectToSousDepartement(Long idService, Long idSousDirection) {
        Service service = this.getServiceById(idService);

    }
}
