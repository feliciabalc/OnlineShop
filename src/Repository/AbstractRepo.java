package Repository;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

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

    private void save(List<String> data) throws IOException {
        FileWriter w = new FileWriter(fileName);  //class used for creating and writing data into a file

        for(String str : data){
                 w.write(str);
        }
        w.close();

       }

    private String load(){
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

