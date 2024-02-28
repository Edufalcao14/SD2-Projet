import java.util.Objects;

public class Ville {

  private int id;
  private String nom;
  private double longitude, latitude;

  public Ville(int id, String nom, double longitude, double latitude) {
    this.id = id;
    this.nom = nom;
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
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
    Ville station = (Ville) o;
    return Objects.equals(nom, station.nom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nom);
  }


}
