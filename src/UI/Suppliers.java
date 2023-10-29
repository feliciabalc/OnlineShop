package UI;

import Controller.SuppliersController;

public class Suppliers {
    private SuppliersController suppliersControllerl;

    public Suppliers(SuppliersController suppliersControllerl) {
        this.suppliersControllerl = suppliersControllerl;
    }

    public SuppliersController getSuppliersControllerl() {
        return suppliersControllerl;
    }

    public void setSuppliersControllerl(SuppliersController suppliersControllerl) {
        this.suppliersControllerl = suppliersControllerl;
    }
}
