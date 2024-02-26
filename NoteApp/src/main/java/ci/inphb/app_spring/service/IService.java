package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Service;

import java.util.List;

public interface IService {

    Service saveService(Service service);
    Service getServiceById(Long idService);
    List<Service> getAllService();
    void deleteService(Long idService);
    Service updateService(Long idService,Service service);
    Service getServiceByName(String libelleService);

    void affectToSousDepartement(Long idService, Long idSousDirection);
}
