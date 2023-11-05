package Repository;

import Entities.Articles;
import Entities.Review;
import Entities.Specifications;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SpecificationsRepo extends AbstractRepo {
    public SpecificationsRepo(String fileName) {

        super(fileName);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
    }

    public void saveOneObj(Specifications specification){
        List<Specifications> specifications =loadSpecifications();
        for(Specifications item : specifications)
            if(item.getId()== specification.getId())
                item = specification;
            else
                specifications.add(specification);
        save(specifications);
    }

    public void deleteObj(Specifications specifications){
        List<Specifications> allSpecifications =loadSpecifications();
        allSpecifications.remove(specifications);
        save(allSpecifications);
    }

    public List<Specifications> loadSpecifications() {
        Type specificationsListType = new TypeToken<List<Specifications>>() {}.getType();
        return load(specificationsListType);
    }
    public List<Specifications> findAll(){
        return loadSpecifications();
    }


    public Specifications findById(int Id){
        List<Specifications> allSpecifications = loadSpecifications();
        Specifications foundItem = null;
        for(Specifications item : allSpecifications){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        List<Specifications> specificationsList = loadSpecifications();
        Specifications foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < specificationsList.size(); i++) {
            Specifications item = specificationsList.get(i);
            if (item.getId() == Id) {
                foundItem = item;
                indexToRemove = i;
                break;
            }
        }

        if (foundItem != null && indexToRemove != -1) {
            specificationsList.remove(indexToRemove);
            save(specificationsList);
            System.out.println( Id + " has been deleted.");
        } else {
            System.out.println(Id + " not found.");
        }
    }

    public void update(int id, Specifications updatedSpecifications) {
        List<Specifications> specificationsList = loadSpecifications();
        boolean found = false;

        for (int i = 0; i < specificationsList.size(); i++) {
            Specifications specifications = specificationsList.get(i);
            if (specifications.getId() == id) {
                specifications.setSize(updatedSpecifications.getSize());
                specifications.setColor(updatedSpecifications.getColor());
                specifications.setQuantity(updatedSpecifications.getQuantity());
                found = true;
                break;
            }
        }
        if (found) {
            save(specificationsList);
            System.out.println( id + " has been updated.");
        } else {
            System.out.println( id + " not found.");
        }
    }
    public void setArticle(Articles article) {
        article = article;
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