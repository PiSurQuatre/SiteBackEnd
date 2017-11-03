package fr.picart.david.entitee;

import com.fasterxml.jackson.annotation.JsonView;
import fr.picart.david.json.JsonViews;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by pic on 03/11/2017.
 */
@Entity
public class Utilisateur {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    @JsonView(JsonViews.Basique.class)
    public Long id;

    @Getter
    @Setter
    @JsonView(JsonViews.Basique.class)
    public String pseudo;

    public Utilisateur(){}

    @Getter
    @Setter
    @OneToMany(mappedBy = "proprietaire")
    @JsonView(JsonViews.Utilisateur.Emails.class)
    private List<Email> emails;

}
