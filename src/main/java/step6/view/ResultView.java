package step6.view;

import step6.domain.Car;
import step6.domain.Cars;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String GUIDE_MESSAGE = "실행 결과";

    private static void printPositionInfo(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printResultGuideMessage() {
        System.out.println(GUIDE_MESSAGE);
    }

    public static void printWinnerCars(List<String> winnerCars) {
        System.out.println(String.join(",", winnerCars)+"가 최종 우승했습니다.");
    }

    public static void printRoundByResults(List<Map<String, Integer>> roundByResults) {
        for (Map<String, Integer> roundByResult : roundByResults) {
            printRoundResult(roundByResult);
        }
    }

    private static void printRoundResult(Map<String, Integer> roundByResult) {
        for (String carName: roundByResult.keySet()) {
            System.out.print(carName + " : ");
            printPositionInfo(roundByResult.get(carName));
        }
        System.out.println();
    }
}
