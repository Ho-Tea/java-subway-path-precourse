package subway.domain;

import java.util.List;

public class Route {

    public Route() {
        initStation();
        initLine();
    }

    public void initStation(){
        for(StationName stationName : StationName.values()){
            StationRepository.addStation(new Station(stationName.name()));
        }
    }

    public void initLine(){
        for (LineName lineName : LineName.values()){
            LineRepository.addLine(new Line(lineName.name()));
        }
    }


}

