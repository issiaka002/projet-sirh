package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.DocAdministratif;
import ci.inphb.app_spring.exception.DocumentAdministratifNotFounException;
import ci.inphb.app_spring.repositories.DocAdministratifRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class DocAdministratifServiceImpl implements DocAdministratifService {

    private DocAdministratifRepository docAdministratifRepository;

    @Override
    public DocAdministratif saveDocAdministratif(DocAdministratif docAdministratif) {
        return docAdministratifRepository.save(docAdministratif);
    }

    @Override
    public DocAdministratif updateDocAdministratif(Long idDocAdministratif, DocAdministratif docAdministratif) {
        return null;
    }

    @Override
    public List<DocAdministratif> getAllDocAdministratif() {
        return docAdministratifRepository.findAll();
    }

    @Override
    public DocAdministratif getDocAdministratif(Long idDocAdministratif) {
        return docAdministratifRepository.findById(idDocAdministratif).orElseThrow(()->new DocumentAdministratifNotFounException("Document administratif not found !!!"));
    }

    @Override
    public void deleteDocAdministratif(Long idDocAdministratif) {

    }
}
