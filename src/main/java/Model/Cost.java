package Model;

public class Cost {
    private final int cost;

    public Cost(int cost) {
        this.cost = cost;
    }

    public boolean noCost() {
        return (cost == 0);
    }

    public int get() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("%,d원", cost);
    }
}
