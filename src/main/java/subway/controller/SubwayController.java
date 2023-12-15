package subway.controller;

import subway.domain.*;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class SubwayController {
    private final Scanner scanner;
    private final OutputView outputView;

    public SubwayController(Scanner scanner, OutputView outputView) {
        this.scanner = scanner;
        this.outputView = outputView;
        init();
    }

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
        while (inputMainFunction()){
            outputView.
        }

        String start = scanner.nextLine();
        String end = scanner.nextLine();
        Calculator calculator = new Calculator(new Station(StationName.valueOf(start)), new Station(StationName.valueOf(end)));
        List<String> stations =  calculator.findShortest();
        for(String station : stations){
            System.out.println(station);
        }
        System.out.println(calculator.sumDistance(stations));
        System.out.println(calculator.sumTime(stations));
    }

    public boolean inputMainFunction(){
        outputView.printBegin();
        String choose = scanner.nextLine();
        if(choose.equals("Q")){
            return false;
        }
        if(Integer.parseInt(choose) == 1){
            return true;
        }
        throw new IllegalArgumentException("해당 문자에 일치하는 기능이 없습니다.");
    }



}

