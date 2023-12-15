package subway.domain;

import java.util.List;


public enum Route {
    교대역_강남역(List.of(StationName.교대역, StationName.강남역), 2, 3),
    강남역_역삼역(List.of(StationName.강남역, StationName.역삼역), 2, 3),
    교대역_남부터미널(List.of(StationName.교대역, StationName.남부터미널역), 3, 2),
    남부터미널_양재역(List.of(StationName.남부터미널역, StationName.양재역), 6, 5),
    양재역_매봉역(List.of(StationName.양재역, StationName.매봉역), 1, 1),
    강남역_양재역(List.of(StationName.강남역, StationName.양재역), 2, 8),
    양재역_양재시민의숲역(List.of(StationName.양재역, StationName.양재시민의숲역), 10, 3);

    private List<StationName> connected;
    private int distance;
    private int time;

    Route(List<StationName> connected, int distance, int time) {
        this.connected = connected;
        this.distance = distance;
        this.time = time;
    }
}
