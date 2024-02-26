package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Conge;

import java.util.List;

public interface CongeService {

    Conge saveConge(Conge conge);
    Conge updateConge(Long idConge, Conge conge);
    List<Conge> getAllConge();
    Conge getConge(Long idConge);
    void deleteConge(Long idConge);
}
