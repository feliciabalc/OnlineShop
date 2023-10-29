package UI;

import Controller.WarehouseController;

public class Warehouse {
    private WarehouseController warehouseController;

    public Warehouse(WarehouseController warehouseController) {
        this.warehouseController = warehouseController;
    }

    public WarehouseController getWarehouseController() {
        return warehouseController;
    }

    public void setWarehouseController(WarehouseController warehouseController) {
        this.warehouseController = warehouseController;
    }
}
