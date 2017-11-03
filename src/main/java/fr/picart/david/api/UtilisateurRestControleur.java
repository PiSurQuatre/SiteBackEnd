package fr.picart.david.api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.picart.david.entitee.Utilisateur;
import fr.picart.david.exception.UtilisateurException;
import fr.picart.david.json.JsonViews;
import fr.picart.david.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pic on 03/11/2017.
 */
@RestController
@RequestMapping("/api")
public class UtilisateurRestControleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @JsonView(JsonViews.Utilisateur.All.class)
    @RequestMapping(value = "/utilisateur", method = RequestMethod.GET )
    public Utilisateur getMoi()
    {
        return new Utilisateur();
    }

    @JsonView(JsonViews.Utilisateur.All.class)
    @RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.GET )
    public Utilisateur getById(@PathVariable(name = "id")long id)
    {
        return utilisateurService.findOne(id);
    }

    @JsonView(JsonViews.Utilisateur.All.class)
    @RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
    public Page<Utilisateur> getTout(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "taille", required = false) Integer taille){
        return utilisateurService.findAll(null!=page&&page>0?page:0, null!=taille&&taille<1000?taille:1000);
    }

    @JsonView(JsonViews.Utilisateur.All.class)
    @RequestMapping(value = "/utilisateur/add", method = RequestMethod.POST)
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateurRecu) throws UtilisateurException {

        if(null!=utilisateurRecu.id)
        {
            throw new UtilisateurException("Un utilisateur ne peut être ajouté s'il possède déjà un id.");
        }

        return utilisateurService.save(utilisateurRecu);
    }

    @RequestMapping(value = "/utilisateur/delete", method = RequestMethod.DELETE)
    public void deleteUtilisateur(@RequestParam(name = "id") long id) throws UtilisateurException {
        utilisateurService.delete(id);
    }

    @JsonView(JsonViews.Utilisateur.All.class)
    @RequestMapping(value = "/utilisateur/update", method = RequestMethod.PUT)
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateurRecu) throws UtilisateurException {

        if(null==utilisateurRecu.id)
        {
            throw new UtilisateurException("Un utilisateur ne peut être modifié que s'il possède un id.");
        }

        return utilisateurService.save(utilisateurRecu);
    }

}
