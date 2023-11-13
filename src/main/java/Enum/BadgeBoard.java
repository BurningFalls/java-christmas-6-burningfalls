package Enum;

public enum BadgeBoard {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private String badgeName;
    private int minimumCost;

    private BadgeBoard(String badgeName, int minimumCost) {
        this.badgeName = badgeName;
        this.minimumCost = minimumCost;
    }

    public static String getBadgeName(int cost) {
        String badgeName = "";
        for (BadgeBoard badge : BadgeBoard.values()) {
            if (badge.minimumCost <= cost) {
                badgeName = badge.badgeName;
            }
        }
        return badgeName;
    }
}
