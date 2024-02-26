package ci.inphb.app_spring.service;

public interface metier {

    //
    void validerAbsence(Long idEmploye, Long idAbsence);
    void validerFormation(Long idEmploye, Long idFormation);
    void validerConge(Long idEmploye, Long Conge);
    void envoyerMail(Long idEmploye);
    void envoyerNotification(Long idEmploye);
}
