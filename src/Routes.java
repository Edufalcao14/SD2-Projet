public class Routes {

    private int idRoute;
    private Villes VilleDepart;
    private Villes VilleArrivee;
    private int duree;

    public Routes(int idRoute, Villes VilleDepart, Villes VilleArrivee, int duree) {
        this.idRoute = idRoute;
        this.VilleDepart = VilleDepart;
        this.VilleArrivee = VilleArrivee;
        this.duree = duree;
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
        return duree;
    }

    @Override
    public String toString() {
        return "Troncon[" +
                "depart=" + VilleDepart.toString()+
                ", arrivee=" + VilleArrivee.toString()+
                ", duree=" + duree +
                " ligne=";
    }
}