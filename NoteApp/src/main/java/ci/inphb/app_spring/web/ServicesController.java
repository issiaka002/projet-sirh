package ci.inphb.app_spring.web;

import ci.inphb.app_spring.entities.Service;
import ci.inphb.app_spring.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/service")
public class ServicesController {

    public IService iservice;

    @GetMapping
    public List<Service> getAllService(){
        return iservice.getAllService();
    }

    @PostMapping
    public Service saveService(@RequestBody Service servic){
        return iservice.saveService(servic);
    }

    @GetMapping("/{idService}")
    public Service getService(@PathVariable Long idService){
        return iservice.getServiceById(idService);
    }

    @DeleteMapping("/{idService}")
    void deleteService(@PathVariable Long idService){
        iservice.deleteService(idService);
    }

    @PutMapping("/{idService}")
    Service updateService(@PathVariable Long idService, @RequestBody Service service){
        return iservice.updateService(idService,service);
    }

    @GetMapping("/serviceName/{idService}")
    Service getServiceByName(@PathVariable String libelleService){
        return iservice.getServiceByName(libelleService);
    }
}
