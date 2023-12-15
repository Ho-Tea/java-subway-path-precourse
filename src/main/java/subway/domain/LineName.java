package subway.domain;

import java.util.List;

public enum LineName {
    LINE_2("2호선", List.of(StationName.교대역, StationName.강남역, StationName.역삼역)),
    LINE_3("3호선", List.of(StationName.교대역, StationName.남부터미널역, StationName.양재역, StationName.매봉역)),

    LINE_SHINBUNDANG("신분당선", List.of(StationName.강남역, StationName.양재역, StationName.양재시민의숲역));

    private String name;
    private List<StationName> stationNames;

    LineName(String name, List<StationName> stationNames) {
        this.name = name;
        this.stationNames = stationNames;
    }
}
