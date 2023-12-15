package subway;

import subway.controller.SubwayController;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        new SubwayController(scanner, new OutputView()).run();
    }
}
