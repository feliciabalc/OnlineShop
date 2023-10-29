package UI;

import Controller.SpecificationsController;

public class Specifications {
    private SpecificationsController specificationsController;

    public Specifications(SpecificationsController specificationsController) {
        this.specificationsController = specificationsController;
    }

    public SpecificationsController getSpecificationsController() {
        return specificationsController;
    }

    public void setSpecificationsController(SpecificationsController specificationsController) {
        this.specificationsController = specificationsController;
    }
}
