package fr.picart.david.service.Implementation;

import fr.picart.david.entitee.Email;
import fr.picart.david.entitee.Utilisateur;
import fr.picart.david.exception.UtilisateurException;
import fr.picart.david.repository.UtilisateurRepository;
import fr.picart.david.service.EmailService;
import fr.picart.david.service.UtilisateurService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Created by pic on 03/11/2017.
 */
@Service
public class UtilisateurServiceImpl implements UtilisateurService{

    static final Logger log = Logger.getLogger(UtilisateurServiceImpl.class);

    @Autowired
    private EmailService emailService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public Page<Utilisateur> findAll(int page, int taille) {
        Pageable pageable = new PageRequest(page, taille);
        return utilisateurRepository.findAll(pageable);
    }

    @Override
    public Utilisateur save(Utilisateur utilisateurRecu) {
        return utilisateurRepository.save(utilisateurRecu);
    }

    @Override
    public void delete(long id) throws UtilisateurException {

        Utilisateur utilisateur = utilisateurRepository.findOne(id);

        if(null==utilisateur.getId())
        {
            throw new UtilisateurException("L'utilisateur "+id+" ne peut être supprimé puisqu'il n'existe pas");
        }

        if(null!=utilisateur.getEmails()&&utilisateur.getEmails().size()>0)
        {
            utilisateur.getEmails().forEach(email -> {
                email.setProprietaire(null);
                email.setActive(false);
                emailService.save(email);
            });
        }

        utilisateurRepository.delete(id);
    }

    @Override
    public Utilisateur findOne(long id) {
        return utilisateurRepository.findOne(id);
    }

}
