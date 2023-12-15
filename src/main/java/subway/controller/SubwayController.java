package subway.controller;

import subway.domain.*;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

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
        while (attempt(() -> inputMainFunction())){
            RouteFunction routeFunction = attempt(() -> inputRouteFunction());
            if(routeFunction.equals(RouteFunction.BACK)){
                continue;
            }
            if(routeFunction.equals(RouteFunction.SHORTEST_DISTANCE)){
                shortestDistance(attempt(() -> inputTotalStation()));
            }
            if(routeFunction.equals(RouteFunction.SHORTEST_TIME)){
                shortestTime(attempt(() -> inputTotalStation()));
            }
        }
    }

    private boolean inputMainFunction(){
        outputView.printBegin();
        String choose = scanner.nextLine();
        if(MainFunction.from(choose).equals(MainFunction.START)){
            return true;
        }
        return false;
    }

    private RouteFunction inputRouteFunction(){
        outputView.printRouteStandard();
        String choose = scanner.nextLine();
        return RouteFunction.from(choose);
    }

    private Calculator inputTotalStation(){
        StationName start = attempt(() -> inputStartStation());
        StationName end = attempt(() -> inputEndStation());
        return new Calculator(new Station(start), new Station(end));
    }

    private StationName inputStartStation(){
        outputView.printStartStation();
        String start = scanner.nextLine();
        return StationName.valueOf(start);
    }
    private StationName inputEndStation(){
        outputView.printEndStation();
        String end = scanner.nextLine();
        return StationName.valueOf(end);
    }
    private void shortestDistance(Calculator calculator){
        List<String> stations =  calculator.findShortestDistance();
        outputView.printResult(calculator.sumDistance(stations), calculator.sumTime(stations), stations);
    }
    private void shortestTime(Calculator calculator){
        List<String> stations =  calculator.findShortestTime();
        outputView.printResult(calculator.sumDistance(stations), calculator.sumTime(stations), stations);
    }

    private <T> T attempt(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return attempt(inputSupplier);
        }
    }


}

