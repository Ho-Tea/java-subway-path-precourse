package subway.domain;

public enum LineName {
    LINE_2("2호선"),
    LINE_3("3호선"),

    LINE_SHINBUNDANG("신분당선");

    private String name;

    LineName(String name) {
        this.name = name;
    }
}
