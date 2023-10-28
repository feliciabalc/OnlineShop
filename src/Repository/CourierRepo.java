package Repository;
import Entities.Employee;
import Entities.Courier;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class CourierRepo extends AbstractRepo {
    public CourierRepo(String fileName) {

        super(fileName);
    }
    @Override
    public void save(List objects) {
        super.save(objects);
    }

    public List<Courier> loadCourier() {
        Type courierListType = new TypeToken<List<Courier>>() {}.getType();
        return load(courierListType);
    }

    public List<Courier> findAll(){
        return loadCourier();
    }


    public Courier findById(int Id){
        List<Courier> allCourier = loadCourier();
        Courier foundItem = null;
        for(Courier item : allCourier){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        List<Courier> courierList = loadCourier();
        Courier foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < courierList.size(); i++) {
            Courier item = courierList.get(i);
            if (item.getId() == Id) {
                foundItem = item;
                indexToRemove = i;
                break;
            }
        }

        if (foundItem != null && indexToRemove != -1) {
            courierList.remove(indexToRemove);
            save(courierList);
            System.out.println( Id + " has been deleted.");
        } else {
            System.out.println(Id + " not found.");
        }
    }



    public void update(int id, Courier updatedCourier) {
        List<Courier> courierList = loadCourier();
        boolean found = false;

        for (int i = 0; i < courierList.size(); i++) {
            Courier courier = courierList.get(i);
            if (courier.getId() == id) {
                courier.setShipping_Address(updatedCourier.getShipping_Address());
                found = true;
                break;
            }
        }

        if (found) {
            save(courierList);
            System.out.println( id + " has been updated.");
        } else {
            System.out.println( id + " not found.");
        }
    }

}