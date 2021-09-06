package step6.domain;

public class CarPosition {
    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public void moveForward() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
