package subway.controller;

import subway.domain.*;

import java.util.Scanner;

public class SubwayController {


    private void init(){
        for(StationName stationName : StationName.values()){
            StationRepository.addStation(new Station(stationName));
        }
        for (LineName lineName : LineName.values()){
            Line line = new Line(lineName);
            line.registerStation(LineName.stations(lineName));
            LineRepository.addLine(line);
        }
    }

    public void run(){
        init();
        final Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        String end = scanner.nextLine();
        Calculator calculator = new Calculator(new Station(StationName.valueOf(start)), new Station(StationName.valueOf(end)));
    }


}

