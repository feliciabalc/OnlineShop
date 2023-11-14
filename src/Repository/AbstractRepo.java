package Repository;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Objects;

abstract public class AbstractRepo<T> {
    private String fileName;

    public AbstractRepo(String fileName) {
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }


    public String getFile(){
        return fileName;
    }

    public void save(List<T> objects) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            String convertToJson = gson.toJson(objects);
            writer.println(convertToJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }








    public List<T> load(Type objectType) {
        Gson gson = new Gson();
        try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
            return gson.fromJson(read, objectType);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return null;
    }

/*

    public List<T> load() {
        Type objectType = new TypeToken<List<T>>() {}.getType();
        Gson gson = new Gson();
        try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
            return gson.fromJson(read, objectType);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception properly
        }
        return null;
    }



*/




}

