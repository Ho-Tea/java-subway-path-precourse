package subway.controller;

import subway.domain.*;

public class Controller {
    public void initStation(){
        for(StationName stationName : StationName.values()){
            StationRepository.addStation(new Station(stationName.name()));
        }
    }

    public void initLine(){
        for (LineName lineName : LineName.values()){
            Line line = new Line(lineName.getName());
            line.registerStation(LineName.stations(lineName));
            LineRepository.addLine(new Line(lineName.name()));
        }
    }


}

