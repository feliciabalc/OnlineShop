package UI;

import Controller.SuppliersController;
import Entities.Suppliers;

import java.util.List;

public class SuppliersUI {
    private SuppliersController suppliersController;

    public SuppliersUI(SuppliersController suppliersController) {
        this.suppliersController = suppliersController;
    }

    public SuppliersController getSuppliersController() {
        return suppliersController;
    }

    public void setSuppliersController(SuppliersController suppliersController) {
        this.suppliersController = suppliersController;
    }
    public List<Entities.Suppliers> loadSuppliers() {
        return suppliersController.loadSuppliers();}

    public void save(List<Entities.Suppliers> suppliers) {
        suppliersController.save(suppliers);}

    public List<Entities.Suppliers> findAll() {
        return suppliersController.findAll();}

    public Entities.Suppliers findById(int Id) {
        return suppliersController.findById(Id);}

    public void delete(int id) {
        suppliersController.delete(id);}

    public void updateTheSuppliers(int id, Suppliers suppliers){
        suppliersController.updateTheSuppliers(id,suppliers);
    }
    public void updateArticleType(int id, String articleType){
         suppliersController.updateArticleType(id, articleType);}

    public List<Suppliers> filteredByName(String name) {
        return suppliersController.filteredByName(name);}
    }
