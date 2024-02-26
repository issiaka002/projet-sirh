package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Direction;
import ci.inphb.app_spring.entities.Ecole;

import java.util.List;


public interface EcoleServie {

    Ecole saveEcole(Ecole ecole);
    Ecole updateEcole(Long idEcole, Ecole ecole);
    List<Ecole> getAllEcole();
    Ecole getEcole(Long idEcole);
    void deleteEcole(Long idEcole);
}
