package step6.domain;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private CarPosition carPosition;

    public Car(String carName) {
        this(carName, 1);
    }

    public Car(String carName, int position) {
        this.carName = new CarName(carName);
        this.carPosition = new CarPosition(position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            carPosition.moveForward();
        }
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carPosition == car.carPosition && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carPosition);
    }
}
