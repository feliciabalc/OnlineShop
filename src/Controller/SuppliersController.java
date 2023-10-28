package Controller;
import Entities.Suppliers;
import Repository.SuppliersRepo;

import java.util.ArrayList;
import java.util.List;

public class SuppliersController {
    private SuppliersRepo suppliersRepo;

    public SuppliersController(SuppliersRepo suppliersRepo) {
        this.suppliersRepo = suppliersRepo;
    }

    public SuppliersRepo getSuppliersRepo() {
        return suppliersRepo;
    }

    public void setSuppliersRepo(SuppliersRepo suppliersRepo) {
        this.suppliersRepo = suppliersRepo;
    }


    public List<Suppliers> loadSuppliers() {
        return suppliersRepo.loadSuppliers();
    }

    public void save(List<Suppliers> suppliers) {
        suppliersRepo.save(suppliers);
    }

    public List<Suppliers> findAll() {
        return suppliersRepo.loadSuppliers();
    }

    public Suppliers findById(int Id) {

        return suppliersRepo.findById(Id);
    }

    public void delete(int id) {
        suppliersRepo.delete(id);
    }

    public void updateTheSuppliers(int id, Suppliers suppliers) {
        suppliersRepo.update(id, suppliers);
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
}

