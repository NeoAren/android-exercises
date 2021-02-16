package eu.neoaren.exercise_5_1;

public class Counter {

    private int counter;
    private final int max;
    private final int min;
    private final int step;

    public Counter(int max, int min, int initial, int step) {
        this.max = max;
        this.min = min;
        this.step = step;
        this.counter = initial;
    }

    public Counter() {
        this(100, -100, 0, 1);
    }

    public void increment() {
        int newValue = this.counter + this.step;
        if (this.min <= newValue && newValue <= this.max) {
            this.counter = newValue;
        }
    }

    public void decrement() {
        int newValue = this.counter - this.step;
        if (this.min <= newValue && newValue <= this.max) {
            this.counter = newValue;
        }
    }

    public void reset() {
        this.counter = 0;
    }

    public int getValue() {
        return this.counter;
    }

}
