package sk.stuba.fei.uim.oop;

public enum NextMove {

    UP(1),
    DOWN(2),
    RIGHT(4),
    LEFT(8),
    NONE(16);

    private int numVal;

    NextMove(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }

}
