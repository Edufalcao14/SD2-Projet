public class Routes {

    private int idRoute;
    private Ville VilleDepart;
    private Ville VilleArrivee;
    private int duree;

    public Routes(int idRoute, Ville VilleDepart, Ville VilleArrivee, int duree) {
        this.idRoute = idRoute;
        this.VilleDepart = VilleDepart;
        this.VilleArrivee = VilleArrivee;
        this.duree = duree;
    }

    public Ville getVilleDepart() {
        return VilleDepart;
    }

    public Ville getVilleArrivee() {
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