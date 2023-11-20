package DB_Repo;

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Objects;

abstract public class AbstractRepository<T> {

    private  String connectionString;
    private  String username;
    private  String password ;

    public AbstractRepository(String connectionString, String username, String password) {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
    }


    public abstract void saveIntoDB(List<T> objects) ;


    public abstract List<T> loadFromDB(Type objectType);





}


