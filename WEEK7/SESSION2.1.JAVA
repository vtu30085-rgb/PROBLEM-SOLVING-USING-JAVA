import java.util.*;

class UndergroundSystem {

    // Stores passenger ID -> check-in information
    private Map<Integer, CheckIn> checkIns;

    // Stores station pair -> total time and number of trips
    private Map<String, Route> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkIns.get(id);

        int travelTime = t - checkIn.time;

        String routeKey = checkIn.station + "->" + stationName;

        Route route = routes.getOrDefault(
            routeKey,
            new Route(0, 0)
        );

        route.totalTime += travelTime;
        route.tripCount++;

        routes.put(routeKey, route);

        // Passenger is no longer travelling
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;

        Route route = routes.get(routeKey);

        return (double) route.totalTime / route.tripCount;
    }

    // Stores check-in information
    static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Stores route statistics
    static class Route {
        int totalTime;
        int tripCount;

        Route(int totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }
}
:::

## How it works

Suppose we have:

```text
checkIn(45, "Leyton", 3)
checkOut(45, "Waterloo", 15)
