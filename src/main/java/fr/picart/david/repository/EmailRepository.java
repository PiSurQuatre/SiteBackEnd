package fr.picart.david.repository;

import fr.picart.david.entitee.Email;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pic on 03/11/2017.
 */
public interface EmailRepository extends JpaRepository<Email, String>{
}
