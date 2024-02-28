public class Route {
    private Ville VilleDepart;
    private Ville VilleArrivee;
    private double distance;

    public Route(Ville VilleDepart, Ville VilleArrivee, double distance) {
        this.VilleDepart = VilleDepart;
        this.VilleArrivee = VilleArrivee;
        this.distance = distance;
    }

    public Ville getVilleDepart() {
        return VilleDepart;
    }

    public Ville getVilleArrivee() {
        return VilleArrivee;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Route{" +
            "VilleDepart=" + VilleDepart +
            ", VilleArrivee=" + VilleArrivee +
            ", distance=" + distance +
            '}';
    }
}