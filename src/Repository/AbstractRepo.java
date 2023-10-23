package Repository;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract public class AbstractRepo {
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

    /*
    protected void save(List<Object> objects) throws IOException {
        List<String> data = new ArrayList<>();
        FileWriter w = new FileWriter(fileName);  //class used for creating and writing data into a file


        for(String str : data){
                 w.write(str);
        }
        w.close();

       }

     */
    public abstract List<String> convertObjectsToStrings(List<?> objects);

    public void save(List<?> objects) throws IOException {
        List<String> data = convertObjectsToStrings(objects);
        FileWriter w = new FileWriter(fileName);
        for (String str : data) {
            w.write(str + "\n");
        }
        w.close();
    }


    protected String load(){
        StringBuilder dataFromFile = new StringBuilder(); //initialize an object to store the data from the file, concatenates its content into a single String using StringBuilder
        try(BufferedReader read = new BufferedReader(new FileReader(fileName))){ //reads line from the file
            String line;
            while((line = read.readLine())!= null){ //reads until the file it empty
                dataFromFile.append(line); //adding to the new file
            }
            return dataFromFile.toString();
        }catch (IOException e){
            e.printStackTrace(); //print the exception if the path is invalid
        }
        return null;

    }



    }

