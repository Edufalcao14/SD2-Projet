import java.util.Objects;

public class Villes {

        private int idVille;
        private String nom;

        private int longitude;

        private int latitude;

        public Villes(int idVille, String nom, int longitude, int latitude) {
            this.idVille = idVille;
            this.nom = nom;
            this.longitude = longitude;
            this.latitude = latitude;
        }

        @Override
        public String toString() {
            return "idVille:" + idVille + ", nom:" + nom + ", longitude:" + longitude + ", latitude:" + latitude;
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
