package Repository;

import Entities.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class WarehouseRepo extends AbstractRepo {
    private EmployeesRepo employeesRepo;
    private ArticlesRepo articlesRepo;
    private SuppliersRepo suppliersRepo;
    private CourierRepo courierRepo;

    public WarehouseRepo(String fileName, String ClientFile, String specificationFilename, String reviewFilename, String courierFile, String ArticlesFile, String employeeFile, String cartFilename, String supplierFile, String orderFile) {

        super(fileName);
        this.courierRepo=new CourierRepo(courierFile,ClientFile,specificationFilename,reviewFilename,ArticlesFile,fileName,employeeFile,cartFilename,supplierFile,orderFile);
        this.employeesRepo= new EmployeesRepo(employeeFile,ClientFile,specificationFilename,reviewFilename,courierFile,fileName,ArticlesFile,cartFilename,supplierFile,orderFile);
        this.articlesRepo=new ArticlesRepo(ArticlesFile,ClientFile,specificationFilename,reviewFilename,courierFile,fileName,employeeFile,cartFilename,supplierFile,orderFile);
        this.suppliersRepo=new SuppliersRepo(supplierFile,ClientFile,specificationFilename,reviewFilename,courierFile,fileName,employeeFile,cartFilename,ArticlesFile,orderFile);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
    }

    public void saveOneObj(Warehouse warehouse){
        List<Warehouse> warehouses =loadWarehouse();
        for(Warehouse item : warehouses)
            if(item.getId()== warehouse.getId())
                item = warehouse;
            else
                warehouses.add(warehouse);
        save(warehouses);
    }

    public void deleteObj(Warehouse warehouse){
        List<Warehouse> allWarehouse =loadWarehouse();
        allWarehouse.remove(warehouse);
        save(allWarehouse);
    }

    public List<Warehouse> loadWarehouse() {
        Type warehouseListType = new TypeToken<List<Warehouse>>() {}.getType();
        return load(warehouseListType);
    }

    public List<Warehouse> findAll(){
        return loadWarehouse();
    }


    public Warehouse findById(int Id){
        List<Warehouse> allWarehouse = loadWarehouse();
        Warehouse foundItem = null;
        for(Warehouse item : allWarehouse){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        List<Warehouse> warehouseList = loadWarehouse();
        Warehouse foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < warehouseList.size(); i++) {
            Warehouse item = warehouseList.get(i);
            if (item.getId() == Id) {
                foundItem = item;
                indexToRemove = i;
                break;
            }
        }

        if (foundItem != null && indexToRemove != -1) {
            warehouseList.remove(indexToRemove);
            save(warehouseList);
            System.out.println( Id + " has been deleted.");
        } else {
            System.out.println(Id + " not found.");
        }
    }

    public void update(int id, Warehouse updatedWarehouse) {
        List<Warehouse> warehouseList = loadWarehouse();
        boolean found = false;

        for (int i = 0; i < warehouseList.size(); i++) {
            Warehouse order = warehouseList.get(i);
            if (order.getId() == id) {
                order.setName(updatedWarehouse.getName());
                order.setAddress(updatedWarehouse.getAddress());
                found = true;
                break;
            }
        }
        if (found) {
            save(warehouseList);
            System.out.println( id + " has been updated.");
        } else {
            System.out.println( id + " not found.");
        }
    }

    public void addArticlesToWarehouse(Warehouse warehouse,int id){
        Articles article=articlesRepo.findById(id);
        warehouse.addArticles(article);
        saveOneObj(warehouse);
    }

    public void removeArticlesToWarehouse(Warehouse warehouse,int id){
        Articles article=articlesRepo.findById(id);
        warehouse.removeArticle(article);
        saveOneObj(warehouse);
    }

    public void addEmployeeToWarehouse(Warehouse warehouse,int id){
        Employee employee=employeesRepo.findById(id);
        warehouse.addEmployee(employee);
        saveOneObj(warehouse);
    }

    public void removeEmployeeToWarehouse(Warehouse warehouse,int id){
        Employee employee=employeesRepo.findById(id);
        warehouse.removeEmployee(employee);
        saveOneObj(warehouse);
    }

    public void addSupplierToWarehouse(Warehouse warehouse,int id){
        Suppliers supplier = suppliersRepo.findById(id);
        warehouse.addSuppliers(supplier);
        saveOneObj(warehouse);
    }

    public void removeSupplierToWarehouse(Warehouse warehouse,int id){
        Suppliers supplier = suppliersRepo.findById(id);
        warehouse.removeSuppliers(supplier);
        saveOneObj(warehouse);
    }

    public void addCourierToWarehouse(Warehouse warehouse,int id){
        Courier courier = courierRepo.findById(id);
        warehouse.addCourier(courier);
        saveOneObj(warehouse);
    }

    public void removeCourierToWarehouse(Warehouse warehouse,int id){
        Courier courier = courierRepo.findById(id);
        warehouse.removeCourier(courier);
        saveOneObj(warehouse);
    }

    public void deleteArticles(int id,Articles article) {
        List<Warehouse> warehouseList = loadWarehouse();
        for(int i=0;i<warehouseList.size();i++){
            Warehouse warehouse = warehouseList.get(i);
            if (warehouse.getId() == id) {
                List<Articles> articleList= warehouse.getArticles();
                for( int j=0; j<articleList.size();j++){
                    if(articleList.get(j) ==article){
                        articleList.remove(article);
                        break;
                    }
                }
            }
        }
        save(warehouseList);
        System.out.println("Article has been deleted.");
    }

    public void deleteEmployees(int id,Employee employee) {
        List<Warehouse> warehouseList = loadWarehouse();
        for(int i=0;i<warehouseList.size();i++){
            Warehouse warehouse = warehouseList.get(i);
            if (warehouse.getId() == id) {
                List<Employee> employeeList= warehouse.getEmployees();
                for( int j=0; j<employeeList.size();j++){
                    if(employeeList.get(j) ==employee){
                        employeeList.remove(employee);
                        break;
                    }
                }
            }
        }
        save(warehouseList);
        System.out.println("Employee has been deleted.");
    }

    public void deleteSupplier(int id, Supplier supplier) {
        List<Warehouse> warehouseList = loadWarehouse();
        for(int i=0;i<warehouseList.size();i++){
            Warehouse warehouse = warehouseList.get(i);
            if (warehouse.getId() == id) {
                List<Suppliers> supplierList= warehouse.getSuppliers();
                for( int j=0; j<supplierList.size();j++){
                    if(supplierList.get(j) ==supplier){
                        supplierList.remove(supplier);
                        break;
                    }
                }
            }
        }
        save(warehouseList);
        System.out.println("Item has been deleted.");
    }

    public void deleteCourier(int id,Courier courier) {
        List<Warehouse> warehouseList = loadWarehouse();
        for(int i=0;i<warehouseList.size();i++){
            Warehouse warehouse = warehouseList.get(i);
            if (warehouse.getId() == id) {
                List<Courier> courierList= warehouse.getCouriers();
                for( int j=0; j<courierList.size();j++){
                    if(courierList.get(j) ==courier){
                        courierList.remove(courier);
                        break;
                    }
                }
            }
        }
        save(warehouseList);
        System.out.println("Courier has been deleted.");
    }


    public List<Warehouse> filteredByAddress(String address) {
        List<Warehouse> warehouse = loadWarehouse();
        List<Warehouse> filteredWarehouse = new ArrayList<>();
        for (Warehouse item : warehouse) {
            if (item.getAddress() == address)
                filteredWarehouse.add(item);
        }
        return filteredWarehouse;

    }

}