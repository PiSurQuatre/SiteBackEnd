package fr.picart.david.exception;

import org.apache.log4j.Logger;

/**
 * Created by pic on 03/11/2017.
 */
public class UtilisateurException extends Exception {
    Logger log = Logger.getLogger(UtilisateurException.class);

    public UtilisateurException(String message)
    {
        super(message);
    }

}
