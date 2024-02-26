public class Routes {

    private int idRoute;
    private Villes VilleDepart;
    private Villes VilleArrivee;
    private int distance;

    public Routes(int idRoute, Villes VilleDepart, Villes VilleArrivee, int distance) {
        this.idRoute = idRoute;
        this.VilleDepart = VilleDepart;
        this.VilleArrivee = VilleArrivee;
        this.distance = distance;
    }

    public Villes getVilleDepart() {
        return VilleDepart;
    }

    public Villes getVilleArrivee() {
        return VilleArrivee;
    }

    public int getIdRoute() {
        return idRoute;
    }

    public int getDuree() {
        return distance;
    }

    @Override
    public String toString() {
        return "Troncon[" +
                "depart=" + VilleDepart.toString()+
                ", arrivee=" + VilleArrivee.toString()+
                ", duree=" + distance +
                " ligne=";
    }
}