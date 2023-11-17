package Repository;

import Entities.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SuppliersRepo extends AbstractRepo {
    private WarehouseRepo warehouseRepo;

    public SuppliersRepo(String fileName, String ClientFile, String specificationFilename, String reviewFilename, String courierFile, String warehouseFile, String employeeFile, String cartFilename, String ArticlesFile, String orderFile) {

        super(fileName);
        this.warehouseRepo=new WarehouseRepo(warehouseFile, ClientFile,reviewFilename,specificationFilename,ArticlesFile,orderFile,courierFile,employeeFile,cartFilename,fileName);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
    }

    public void saveOneObj(Suppliers supplier){
        List<Suppliers> suppliers =loadSuppliers();
        for(Suppliers item : suppliers)
            if(item.getId()== supplier.getId())
                item = supplier;
            else
                suppliers.add(supplier);
        save(suppliers);
    }

    public void deleteObj(Suppliers suppliers){
        List<Suppliers> allSuppliers =loadSuppliers();
        allSuppliers.remove(suppliers);
        save(allSuppliers);
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

    public void updateArticleType(int id, String articleType){
        List<Suppliers> suppliersList = loadSuppliers();
        boolean found = false;

        for (int i = 0; i < suppliersList.size(); i++) {
            Suppliers suppliers = suppliersList.get(i);
            if (suppliers.getId() == id) {
                suppliers.setArticleType(articleType);
                found = true;
                break;
            }
        }
        if (found) {
            save(suppliersList);
            System.out.println("Suppliers with ID " + id + " has been updated.");
        } else {
            System.out.println("Suppliers with ID " + id + " not found.");
        }
    }

    public List<Suppliers> filteredByName(String name) {
        List<Suppliers> suppliers = loadSuppliers();
        List<Suppliers> filteredSuppliers = new ArrayList<>();
        for (Suppliers item : suppliers) {
            if (item.getName() == name)
                filteredSuppliers.add(item);
        }
        return filteredSuppliers;

    }

    public Warehouse getWarehouse(Suppliers suppliers, int id){
        Warehouse warehouse = warehouseRepo.findById(id);
        suppliers.setWarehouse(warehouse);
        return suppliers.getWarehouse();
    }
}