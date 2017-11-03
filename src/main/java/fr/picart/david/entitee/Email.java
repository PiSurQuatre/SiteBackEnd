package fr.picart.david.entitee;

import com.fasterxml.jackson.annotation.JsonView;
import fr.picart.david.json.JsonViews;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by pic on 03/11/2017.
 */
@Entity
public class Email {

    @Getter
    @Setter
    @Id
    @JsonView(JsonViews.Basique.class)
    private String email;

    @Getter
    @Setter
    @JsonView(JsonViews.Basique.class)
    private boolean active;

    public Email(){}

    public Email(String email) {
        this.active = true;
        this.email = email;
    }

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "mto_email_proprietaire")
    @JsonView(JsonViews.Email.Proprietaire.class)
    private Utilisateur proprietaire;

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", active=" + active +
                ", proprietaire=" + proprietaire +
                '}';
    }
}
