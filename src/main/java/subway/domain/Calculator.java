package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final Station start;
    private final Station end;

    public Calculator(Station start, Station end) {
        validateRoute(start, end);
        this.start = start;
        this.end = end;
    }
    private void validateRoute(Station start, Station end){
        if(start.equals(end)){
            throw new IllegalArgumentException("출발역과 도착역이 동일합니다");
        }
    }

    private WeightedMultigraph<String, DefaultWeightedEdge> init(){
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        for(Station station : StationRepository.stations()){
            graph.addVertex(station.getName());
        }
        return graph;
    }

    public List<String> findShortest() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = init();
        for (Route route : Route.values()) {
            List<StationName> connected = route.getConnected();
            graph.setEdgeWeight(graph.addEdge(connected.get(0).toString(), connected.get(1).toString()), route.getDistance());
        }
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(start.getName(), end.getName()).getVertexList();
    }


    public int sumDistance(List<String> stations){
        int sum = 0;
        for(int i = 0; i < stations.size()-1; i++){
            sum += Route.distance(StationName.valueOf(stations.get(i)), StationName.valueOf(stations.get(i+1)));
        }
        return sum;
    }

    public int sumTime(List<String> stations){
        int sum = 0;
        for(int i = 0; i < stations.size()-1; i++){
            sum += Route.time(StationName.valueOf(stations.get(i)), StationName.valueOf(stations.get(i+1)));
        }
        return sum;
    }



}

