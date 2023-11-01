package Controller;
import Entities.Suppliers;
import Entities.Warehouse;
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

    public void save() {
        Suppliers sup1= new Suppliers(1,"Silviu",0766.98762,"tricouri");
        Suppliers sup2= new Suppliers(2,"Dragomir",0766.93462,"bluze");
        Suppliers sup3= new Suppliers(3,"Vlad",0766.94444,"pantaloni");
        List<Suppliers> suppliers = new ArrayList<>();
        suppliers.add(sup1);
        suppliers.add(sup2);
        suppliers.add(sup3);

        Warehouse war1= new Warehouse(1,"R&F","Gruia 58");
        sup1.setWarehouse(war1);

        suppliersRepo.save(suppliers);
    }

    public void saveOneObj(Suppliers supplier){ suppliersRepo.saveOneObj(supplier);}

    public void deleteObj(Suppliers suppliers){ suppliersRepo.deleteObj(suppliers);}

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
            save();
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
    public void setWarehouse(Warehouse warehouse) {
        suppliersRepo.setWarehouse(warehouse);
    }
}

