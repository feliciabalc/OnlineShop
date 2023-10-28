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

    public void save(List<Specifications> specifications) {
        specificationsRepo.save(specifications);
    }

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
        List<Specifications> specificationsList = loadSpecifications();
        boolean found = false;

        for (int i = 0; i < specificationsList.size(); i++) {
            Specifications specifications = specificationsList.get(i);
            if (specifications.getId() == id) {
                specifications.setColor(color);
                found = true;
                break;
            }
        }
        if (found) {
            save(specificationsList);
            System.out.println("Specifications with ID " + id + " has been updated.");
        } else {
            System.out.println("Specifications with ID " + id + " not found.");
        }
    }

    public void updateteQuantity(int id, double quantity){
        List<Specifications> specificationsList = loadSpecifications();
        boolean found = false;

        for (int i = 0; i < specificationsList.size(); i++) {
            Specifications specifications = specificationsList.get(i);
            if (specifications.getId() == id) {
                specifications.setQuantity(quantity);
                found = true;
                break;
            }
        }
        if (found) {
            save(specificationsList);
            System.out.println("Specifications with ID " + id + " has been updated.");
        } else {
            System.out.println("Specifications with ID " + id + " not found.");
        }
    }

    public void updateteSize(Articles article, String size, String newSize){
        List<Specifications> specificationsList = loadSpecifications();
        boolean found = false;

        for (int i = 0; i < specificationsList.size(); i++) {
            Specifications specification = specificationsList.get(i);
            if (specification.getArticle() == article) {
                String[] allSizes = specification.getSize();
                for(int j = 0; j < allSizes.length; j++){
                    if(allSizes[j] == size)
                        allSizes[j] = newSize;
                }

                found = true;
                break;
            }
        }
        if (found) {
            save(specificationsList);
            System.out.println("Specifications has been updated.");
        } else {
            System.out.println("Specifications not found.");
        }
    }

    public List<Specifications> filteredByColor(String color) {
        List<Specifications> specifications = loadSpecifications();
        List<Specifications> filteredSpecifications = new ArrayList<>();
        for (Specifications item : specifications) {
            if (item.getColor() == color)
                filteredSpecifications.add(item);
        }
        return filteredSpecifications;

    }

    public List<Specifications> filteredBySize(String size) {
        List<Specifications> specifications = loadSpecifications();
        List<Specifications> filteredSpecifications = new ArrayList<>();
        for (Specifications item : specifications) {
            String[] allSizes = item.getSize();
            for (int j = 0; j < allSizes.length; j++) {
                if (allSizes[j] == size) {
                    filteredSpecifications.add(item);
                }
            }}
            return filteredSpecifications;

        }

    }
