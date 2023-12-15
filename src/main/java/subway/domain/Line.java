package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private LineName lineName;

    private List<Station> stations;

    public Line(LineName lineName) {
        this.lineName = lineName;
        this.stations = new ArrayList<>();
    }

    public String getName() {
        return lineName.getName();
    }

    public void registerStation(List<Station> stations) {
        this.stations = new ArrayList<>(stations);
    }

}
