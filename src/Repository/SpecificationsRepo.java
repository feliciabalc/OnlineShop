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
        specifications.add(specification);
        save(specifications);
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
}