package DB_Controller;

import DB_Repo.ClientRepoDB;
import Entities.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientControllerDB {
    private ClientRepoDB clientRepo;

    public ClientControllerDB(ClientRepoDB clientRepo) {
        this.clientRepo = clientRepo;
    }
    public void saveIntoDB(List<Client> clients) {
        clientRepo.saveIntoDB(clients);
    }

    public Client createClientFromResultSet(ResultSet resultSet) throws SQLException {
        return clientRepo.createClientFromResultSet(resultSet);
    }

    public List<Client> loadFromDB() {
        return  clientRepo.loadFromDB();
    }

    public Client findById(int Id) {
        return clientRepo.findById(Id);
    }

    public void delete(int Id) {
        clientRepo.delete(Id);
    }

    public void updateAddress(int Id, String address) {
        clientRepo.updateAddress(Id,address);
    }

    public List<Client> filterByName(String name) {
        return clientRepo.filterByName(name);
    }
}
