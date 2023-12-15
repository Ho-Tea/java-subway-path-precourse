package subway.domain;

import java.util.Arrays;

public enum RouteFunction {
    SHORTEST_DISTANCE("1"),
    SHORTEST_TIME("2"),
    BACK("B"),
    ;

    private String name;

    RouteFunction(String name) {
        this.name = name;
    }

    public static RouteFunction from(String target){
        return Arrays.stream(values())
                .filter(function -> function.name.equals(target))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 문자가 존재하지 않습니다"));
    }
}
