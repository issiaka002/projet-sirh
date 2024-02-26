package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.DocAdministratif;

import java.util.List;

public interface DocAdministratifService {

    DocAdministratif saveDocAdministratif(DocAdministratif docAdministratif);
    DocAdministratif updateDocAdministratif(Long idDocAdministratif, DocAdministratif docAdministratif);
    List<DocAdministratif> getAllDocAdministratif();
    DocAdministratif getDocAdministratif(Long idDocAdministratif);
    void deleteDocAdministratif(Long idDocAdministratif);
}
