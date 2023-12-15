package subway.domain;

import java.util.Arrays;

public enum MainFunction {
    START("1"),
    QUIT("Q"),
    ;
    private String name;

    MainFunction(String name) {
        this.name = name;
    }

    public static MainFunction from(String target){
        return Arrays.stream(values())
                .filter(function -> function.name.equals(target))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 문자에 일치하는 기능이 없습니다."));
    }
}
