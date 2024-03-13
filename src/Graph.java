import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

  private Map<Ville, Set<Route>> mapRoutes; // map des villes -> villes connectées
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
      Route routeVilleDepart = new Route(villeDepart, villeArrivee, Util.distance(villeArrivee.getLatitude(),
          villeArrivee.getLongitude(), villeDepart.getLatitude(), villeDepart.getLongitude()));
      mapRoutes.get(villeDepart).add(routeVilleDepart);
      Route routeVilleArrivee = new Route(villeArrivee, villeDepart, Util.distance(villeArrivee.getLatitude(),
          villeArrivee.getLongitude(), villeDepart.getLatitude(), villeDepart.getLongitude()));
      mapRoutes.get(villeArrivee).add(routeVilleArrivee); // Pour l'unidirection des routes
    }
  }

  public void calculerItineraireMinimisantNombreRoutes(String depart, String arrivee) {
    if (depart == null || arrivee == null || depart.isBlank() || arrivee.isBlank()) {
      throw new IllegalArgumentException("Veuillez entrer 2 noms de ville !");
    }

    LinkedList<Ville> file = new LinkedList<>();
    Set<Ville> villesVisitee = new HashSet<>();
    Map<Ville, Ville> troncons = new HashMap<>();
    List<Route> chemin = new ArrayList<>();

    Ville villeDepart = mapVilles.get(depart);
    Ville villeArrivee = mapVilles.get(arrivee);

    file.addFirst(villeDepart);
    villesVisitee.add(villeDepart);

    //BFS
    while (!villesVisitee.contains(villeArrivee)) {
      Ville villeDepartTemp = file.removeLast();
      for (Route r : mapRoutes.get(villeDepartTemp)) {
        Ville villeArriveeTemp = r.getVilleArrivee();
        if (!villesVisitee.contains(villeArriveeTemp)) {
          file.addFirst(villeArriveeTemp);
          villesVisitee.add(villeArriveeTemp);
          troncons.put(villeArriveeTemp, villeDepartTemp);
        }
      }
    }

    int longeurCheminTotal = 0;

    //création du chemin en partant de l'arrivée jusqu'au départ
    while (!villeArrivee.equals(villeDepart)) {
      for (Route r : mapRoutes.get(troncons.get(villeArrivee))) {
        if (r.getVilleArrivee().equals(villeArrivee)) {
          chemin.add(r);
          longeurCheminTotal += r.getDistance();
          break;
        }
      }
      villeArrivee = troncons.get(villeArrivee);
    }

    int nbrRoutes = chemin.size();
    String returnString =
        " Trajet de " + depart + " à " + arrivee + " : " + nbrRoutes + " routes et "
            + longeurCheminTotal + "km";
    System.out.println(returnString);
    }
  }
