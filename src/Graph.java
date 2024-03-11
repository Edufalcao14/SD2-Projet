import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

  private Map<Ville, Set<Ville>> mapRoutes; // map des villes -> villes connectées
  private Map<String, Ville> mapVilles; // map pour recuperer une ville sur base d'une string
  private Map<Integer, Ville> mapIdVilles; // map pour recuperer une ville sur base de son id

  public Graph(File cities, File roads) throws IOException {
    FileReader frcities = new FileReader(cities);
    BufferedReader brcities = new BufferedReader(frcities);
    FileReader frRoads = new FileReader(roads);
    BufferedReader brRoads = new BufferedReader(frRoads);
    mapVilles = new HashMap<>();
    mapIdVilles = new HashMap<>();
    String str;
    String[] tabVilles;
    String[] tabRoutes;

    while ((str = brcities.readLine()) != null) {
      tabVilles = str.split(",");
      int id = Integer.parseInt(tabVilles[0]);
      String nom = tabVilles[1];
      double latitude = Double.parseDouble(tabVilles[2]);
      double longitude = Double.parseDouble(tabVilles[3]);
      Ville ville = new Ville(id, nom, longitude, latitude);
      mapIdVilles.put(id, ville);
      mapVilles.put(nom, ville);
    }

    mapRoutes = new HashMap<>();
    for (Ville ville : mapVilles.values()) {
      mapRoutes.put(ville, new HashSet<>());
    }

    while ((str = brRoads.readLine()) != null) {
      tabRoutes = str.split(",");
      int idVilleDepart = Integer.parseInt(tabRoutes[0]);
      Ville villeDepart = mapIdVilles.get(idVilleDepart);
      int idVilleArrivee = Integer.parseInt(tabRoutes[1]);
      Ville villeArrivee = mapIdVilles.get(idVilleArrivee);
      Route route = new Route(villeDepart, villeArrivee, Util.distance(villeArrivee.getLatitude(),
          villeArrivee.getLongitude(), villeDepart.getLatitude(), villeDepart.getLongitude()));
      mapRoutes.get(villeDepart).add(villeArrivee);
      mapRoutes.get(villeArrivee).add(villeDepart); // Pour l'unidirection des routes
    }
  }



}