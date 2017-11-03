package fr.picart.david.service;

import fr.picart.david.entitee.Email;

/**
 * Created by pic on 03/11/2017.
 */
public interface EmailService {

    Email findOne(String email);

    Email save(Email email);
}
