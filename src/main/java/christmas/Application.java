package christmas;

import Controller.ChristmasController;

public class Application {
    public static void main(String[] args) {
        ChristmasController christmasController = new ChristmasController();
        christmasController.startPromotion();
    }
}
