package Repository;

import Entities.Orders;
import Entities.Warehouse;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class WarehouseRepo extends AbstractRepo {
    public WarehouseRepo(String fileName) {

        super(fileName);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
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

}