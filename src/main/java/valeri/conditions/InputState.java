package valeri.conditions;

public class InputState {

    private boolean first;
    private boolean second;
    private boolean third;

    public InputState(boolean first, boolean second, boolean third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isSecond() {
        return second;
    }

    public boolean isThird() {
        return third;
    }
}
