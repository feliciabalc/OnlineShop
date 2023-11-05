package Controller;
import Entities.Articles;
import Entities.Specifications;
import Repository.SpecificationsRepo;

import java.util.ArrayList;
import java.util.List;

public class SpecificationsController {
    private SpecificationsRepo specificationsRepo;

    public SpecificationsController(SpecificationsRepo specificationsRepo) {
        this.specificationsRepo = specificationsRepo;
    }

    public SpecificationsRepo getSpecificationsRepo() {
        return specificationsRepo;
    }

    public void setSpecificationsRepo(SpecificationsRepo specificationsRepo) {
        this.specificationsRepo = specificationsRepo;
    }


    public List<Specifications> loadSpecifications() {
        return specificationsRepo.loadSpecifications();
    }

    public void save() {
        Specifications sp1=new Specifications(1, new String[]{"S", "M"},"rosu",25,true);
        Specifications sp2=new Specifications(2, new String[]{"S", "L"},"crem",4,true);
        Specifications sp3=new Specifications(3, new String[]{"S", "M","XL"},"verde",13,true);
        List<Specifications> specifications = new ArrayList<>();
        specifications.add(sp1);
        specifications.add(sp2);
        specifications.add(sp3);
        Articles a1  = new Articles(1,"bluza", "cx", "bumbac", "maneca", 24);
        sp1.setArticle(a1);
        specificationsRepo.save(specifications);}


    public void saveOneObj(Specifications specification){ specificationsRepo.saveOneObj(specification);}

    public void deleteObj(Specifications specifications){ specificationsRepo.deleteObj(specifications);}

    public List<Specifications> findAll() {
        return specificationsRepo.loadSpecifications();
    }

    public Specifications findById(int Id) {

        return specificationsRepo.findById(Id);
    }

    public void delete(int id) {
        specificationsRepo.delete(id);
    }

    public void updateTheSpecifications(int id, Specifications specifications) {
        specificationsRepo.update(id, specifications);
    }


    public void updateColor(int id, String color){
       specificationsRepo.updateColor(id, color);
    }

    public void updateteQuantity(int id, double quantity){
        specificationsRepo.updateteQuantity(id, quantity);
    }

    public void updateteSize(Articles article, String size, String newSize){
       specificationsRepo.updateteSize(article, size, newSize);
    }

    public List<Specifications> filteredByColor(String color) {
        return specificationsRepo.filteredByColor(color);

    }

    public List<Specifications> filteredBySize(String size) {
        return specificationsRepo.filteredBySize(size);
        }
    public void setArticle(Articles article) {
        specificationsRepo.setArticle(article);
    }

    }
