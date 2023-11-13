package Model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cost other = (Cost) obj;
        return (cost == other.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost);
    }
}
