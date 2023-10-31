package Repository;

import Entities.Review;
import Entities.Suppliers;
import Entities.Warehouse;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SuppliersRepo extends AbstractRepo {
    public SuppliersRepo(String fileName) {

        super(fileName);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
    }

    public void saveOneObj(Suppliers supplier){
        List<Suppliers> suppliers =loadSuppliers();
        suppliers.add(supplier);
        save(suppliers);
    }

    public List<Suppliers> loadSuppliers() {
        Type suppliersListType = new TypeToken<List<Suppliers>>() {}.getType();
        return load(suppliersListType);
    }
    public List<Suppliers> findAll(){
        return loadSuppliers();
    }


    public Suppliers findById(int Id){
        List<Suppliers> allSuppliers = loadSuppliers();
        Suppliers foundItem = null;
        for(Suppliers item : allSuppliers){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        List<Suppliers> suppliersList = loadSuppliers();
        Suppliers foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < suppliersList.size(); i++) {
            Suppliers item = suppliersList.get(i);
            if (item.getId() == Id) {
                foundItem = item;
                indexToRemove = i;
                break;
            }
        }

        if (foundItem != null && indexToRemove != -1) {
            suppliersList.remove(indexToRemove);
            save(suppliersList);
            System.out.println( Id + " has been deleted.");
        } else {
            System.out.println(Id + " not found.");
        }
    }



    public void update(int id, Suppliers updatedSuppliers) {
        List<Suppliers> suppliersList = loadSuppliers();
        boolean found = false;

        for (int i = 0; i < suppliersList.size(); i++) {
            Suppliers suppliers = suppliersList.get(i);
            if (suppliers.getId() == id) {
                suppliers.setName(updatedSuppliers.getName());
                suppliers.setTelefon(updatedSuppliers.getTelefon());
                found = true;
                break;
            }
        }
        if (found) {
            save(suppliersList);
            System.out.println( id + " has been updated.");
        } else {
            System.out.println( id + " not found.");
        }
    }
    public void setWarehouse(Warehouse warehouse) {
        warehouse = warehouse;
    }
}