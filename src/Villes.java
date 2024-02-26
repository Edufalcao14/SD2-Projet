import java.util.Objects;

public class Villes {

        private String nom;

        public Villes(String nom) {
            this.nom = nom;
        }

        @Override
        public String toString() {
            return nom;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Villes station = (Villes) o;
            return Objects.equals(nom, station.nom);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nom);
        }



}
