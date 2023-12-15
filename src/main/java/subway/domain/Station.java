package subway.domain;

import java.util.Objects;

public class Station {
    private StationName stationName;

    public Station(StationName stationName) {
        this.stationName = stationName;
    }

    public String getName() {
        return stationName.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return stationName == station.stationName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationName);
    }
}
