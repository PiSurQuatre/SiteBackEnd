package fr.picart.david.service.Implementation;

import fr.picart.david.entitee.Email;
import fr.picart.david.repository.EmailRepository;
import fr.picart.david.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pic on 03/11/2017.
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Override
    public Email findOne(String email) {
        return emailRepository.findOne(email);
    }

    @Override
    public Email save(Email email) {
        return emailRepository.save(email);
    }
}
