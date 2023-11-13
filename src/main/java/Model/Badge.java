package Model;

public class Badge {
    private String badgeName;

    public Badge(String badgeName) {
        this.badgeName = badgeName;
    }

    @Override
    public String toString() {
        if (badgeName.isEmpty()) {
            return "없음";
        }
        return badgeName;
    }
}
