package step6.view;

import step6.domain.CarName;
import step6.domain.CarPosition;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String GUIDE_MESSAGE = "실행 결과";

    private static void printPositionInfo(CarPosition carPosition) {
        for (int i = 0; i < carPosition.getPosition(); i++) {
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

    public static void printRoundByResults(List<Map<CarName, CarPosition>> roundByResults) {
        for (Map<CarName, CarPosition> roundByResult : roundByResults) {
            printRoundResult(roundByResult);
        }
    }

    private static void printRoundResult(Map<CarName, CarPosition> roundByResult) {
        for (CarName carName: roundByResult.keySet()) {
            System.out.print(carName.getCarName() + " : ");
            printPositionInfo(roundByResult.get(carName));
        }
        System.out.println();
    }
}
