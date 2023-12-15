package subway.view;

import java.util.List;

public class OutputView {

    public void printBegin(){
        System.out.println("## 메인 화면\n" +
                "1. 경로 조회\n" +
                "Q. 종료" + System.lineSeparator());
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public void printRouteStandard(){
        System.out.println("## 경로 기준\n" +
                "1. 최단 거리\n" +
                "2. 최소 시간\n" +
                "B. 돌아가기" + System.lineSeparator());
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public void printStartStation(){
        System.out.println(System.lineSeparator() + "## 출발역을 입력하세요.");
    }

    public void printEndStation(){
        System.out.println(System.lineSeparator() + "## 도착역을 입력하세요.");
    }

    public void printResult(int distance, int time, List<String> stations){
        System.out.print(System.lineSeparator() +
                "## 조회 결과\n" +
                "[INFO] ---\n" +
                String.format("[INFO] 총 거리: %dkm\n", distance) +
                String.format("[INFO] 총 소요 시간: %d분\n", time) +
                "[INFO] ---\n");
        for(String station : stations){
            System.out.println(String.format("[INFO] %s",station));
        }
        System.out.println();
    }

    public void printException(String message) {
        System.out.println("[ERROR] " + message);
    }
}
