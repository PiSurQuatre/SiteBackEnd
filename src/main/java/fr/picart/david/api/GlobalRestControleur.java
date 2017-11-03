package fr.picart.david.api;

import fr.picart.david.exception.StopAttackingThisAPI;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pic on 03/11/2017.
 */
@RestController
public class GlobalRestControleur {

    static final Logger log = Logger.getLogger(GlobalRestControleur.class);

    @RequestMapping({"*","/*", "/**", "/*/*"})
    public void notMapped(
            HttpServletRequest requete,
            HttpServletResponse reponse) throws StopAttackingThisAPI {
        reponse.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
        //TODO: Spécifier plus d'informations
        log.error(requete.getRemoteHost()+":"+requete.getRemotePort()+" essaye d'accéder à des URLs n'ont mappées.");
        throw new StopAttackingThisAPI("Cette URL n'existe pas (encore). ");
    }

}
