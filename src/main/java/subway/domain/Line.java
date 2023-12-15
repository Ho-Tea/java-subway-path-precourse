package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;

    private List<Station> stations;

    public Line(String name) {
        this.name = name;
        this.stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void registerStation(List<Station> stations){
        this.stations = new ArrayList<>(stations);
    }

    // 추가 기능 구현
}
