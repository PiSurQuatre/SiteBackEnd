package fr.picart.david.json;

/**
 * Created by pic on 03/11/2017.
 */
public class JsonViews {

    public interface Basique{}

    public interface Email extends Basique{
        public interface Proprietaire{
        }
    }

    public interface Utilisateur extends Basique {
        public interface All extends Emails{
        }
        public interface Emails extends Basique {
        }
    }
}
