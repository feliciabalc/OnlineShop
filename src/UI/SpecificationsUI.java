package UI;

import Controller.SpecificationsController;
import Entities.Articles;
import Entities.Specifications;

import java.util.List;

public class SpecificationsUI {
    private SpecificationsController specificationsController;

    public SpecificationsUI(SpecificationsController specificationsController) {
        this.specificationsController = specificationsController;
    }

    public SpecificationsController getSpecificationsController() {
        return specificationsController;
    }

    public void setSpecificationsController(SpecificationsController specificationsController) {
        this.specificationsController = specificationsController;
    }

    public void saveOneObj(Specifications specification){ specificationsController.saveOneObj(specification);}

    public void deleteObj(Specifications specifications){ specificationsController.deleteObj(specifications);}

    public List<Entities.Specifications> loadSpecifications(){
        return specificationsController.loadSpecifications();}

    public void save() {
        specificationsController.save();
    }
    public List<Entities.Specifications> findAll() {
        return specificationsController.findAll();}

    public Entities.Specifications findById(int Id) {
        return specificationsController.findById(Id);}

    public void delete(int id) {
        specificationsController.delete(id);}

    public void updateTheSpecifications(int id, Entities.Specifications specifications) {
        specificationsController.updateTheSpecifications(id, specifications);
    }
    public void updateColor(int id, String color){
        specificationsController.updateColor(id, color);}

    public void updateteQuantity(int id, double quantity){
        specificationsController.updateteQuantity(id, quantity);
    }
    public void updateteSize(Articles article, String size, String newSize){
        specificationsController.updateteSize(article, size, newSize);
    }
    public List<Entities.Specifications> filteredByColor(String color) {
        return specificationsController.filteredByColor(color);
    }
    public List<Entities.Specifications> filteredBySize(String size) {
        return specificationsController.filteredBySize(size);
    }


    }
