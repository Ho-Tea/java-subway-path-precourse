package subway.domain;

import java.util.List;

public class Route {
    private final Station start;
    private final Station end;

    public Route(Station start, Station end) {
        validateRoute(start, end);
        this.start = start;
        this.end = end;
    }
    void validateRoute(Station start, Station end){
        if(start.equals(end)){
            throw new IllegalArgumentException("출발역과 도착역이 동일합니다");
        }
    }

    public void getShortestPath(){

    }




}

