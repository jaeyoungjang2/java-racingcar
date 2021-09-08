package step6.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    private final Cars cars;

    private List<String> winnerCars = new ArrayList<>();
    private List<Map<CarName, CarPosition>> resultByRound = new ArrayList<>();
    private int maxPosition = 0;

    public Referee(Cars cars) {
        this.cars = cars;
    }

    public List<String> calculateLastResults() {
        findMaxposition();
        findWinner();
        return winnerCars;
    }

    private void findWinner() {
        cars.getCars()
                .forEach(car -> findWinnerCar(car));
    }

    private void findMaxposition() {
        cars.getCars()
                .forEach(car -> findMaxPositionByCar(car));
    }

    private void findWinnerCar(Car car) {
        if (car.getPosition() == maxPosition) {
            winnerCars.add(car.getCarName());
        }
    }

    public void findMaxPositionByCar(Car car) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
        }
    }

    public void recordCurrentMatchResult(Cars cars) {
        resultByRound.add(new HashMap<>());
        for (Car car: cars.getCars()) {
            int tryNumber = resultByRound.size() - 1;
            resultByRound.get(tryNumber).put(new CarName(car.getCarName()), new CarPosition(car.getPosition()));
        }
    }

    public List<Map<CarName, CarPosition>> calculateRoundByResults() {
        return resultByRound;
    }
}
