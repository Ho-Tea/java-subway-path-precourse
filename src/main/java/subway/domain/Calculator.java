package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

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

    public WeightedMultigraph<String, DefaultWeightedEdge> init(){
        WeightedMultigraph<String, DefaultWeightedEdge> graph
                = new WeightedMultigraph(DefaultWeightedEdge.class);
        for(Station station : StationRepository.stations()){
            graph.addVertex(station.getName());
        }
        return graph;
    }




}

