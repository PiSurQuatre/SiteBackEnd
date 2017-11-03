package fr.picart.david.service;

import fr.picart.david.entitee.Utilisateur;
import fr.picart.david.exception.UtilisateurException;
import org.springframework.data.domain.Page;

/**
 * Created by pic on 03/11/2017.
 */
public interface UtilisateurService {

    Page<Utilisateur> findAll(int page, int taille);

    Utilisateur save(Utilisateur utilisateurRecu);

    void delete(long id) throws UtilisateurException;

    Utilisateur findOne(long id);
}
