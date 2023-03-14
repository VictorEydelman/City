package Parser;
import Collections.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Класс отвечающий за чтение CSV файла, парсинг из него.
 */

public class CSVParser {
    final String[] args;
    private static Map<Integer, City> map;
    private static ZonedDateTime creationDate;
    private static Path fileName;

    public CSVParser(String[] args) {
        this.args = args;
    }

    /**
     * Method for determining the time of collection creation
     */
    public static void creationTree(){
        if (map==null){
            creationDate=ZonedDateTime.now();
        }
        map=new TreeMap<>();
    }

    /**
     *
     * @param arg
     * @throws IOException
     * @throws ParseException
     */
    public static void Reader(String[] arg) throws IOException, ParseException {
        String file="";

        if (arg.length>0) {
            //System.out.println(arg[0]);
            arg[0]=arg[0].replace("/","//");
            //System.out.println(arg[0]);
            fileName = Path.of(arg[0]);
        } else {
            file = "file.csv";
            fileName = Path.of(file);
        }
        Parse(fileName);
    }
    public static void Parse(Path fileName) throws IOException, ParseException {
        //String file2 = "C:\Users\veyde\OneDrive\Документы\Работы ИТМО\\Программирование\\City\\file.csv";
        //fileName =Path.of(file2);
        FileInputStream input = new FileInputStream(fileName.toFile());
        InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        int i;
        String line = "";
        String[] line1;
        Boolean t=false;
        while ((i = reader.read()) != -1) {
            char point = (char) i;
            if (point!='\r' && point!='\n') {
                line += point;
            }
            if (point =='\n') {
                if (t) {
                    String creation=String.valueOf(LocalDate.now());
                    line+=","+creation;
                    line1 = line.split(",");
                    int key = Integer.parseInt(line1[0]);
                    line1[0] = Integer.toString(map.size()+1);
                    //System.out.println(line);
                    Work_with_TreeMap.Add_to_TreeMap(map, key, line1);
                }
                t=true;
                line = "";
            }
        }
        String creation=String.valueOf(LocalDate.now());
        line+=","+creation;
        line1 = line.split(",");
        int key = Integer.parseInt(line1[0]);
        line1[0] = Integer.toString(map.size()+1);
        Work_with_TreeMap.Add_to_TreeMap(map, key, line1);
    }

    public static String getName(){
        return map.getClass().getName();
    }

    public static ZonedDateTime getcreatTime(){
        return creationDate;
    }

    public static int getsize(){
        return map.size();
    }

    public static String getAllElements(){
        String list="";
        for (Map.Entry<Integer,City> entry:map.entrySet()) {
            list += entry.getKey() + " = ";
            list += entry.getValue();
            list += '\n';
        }
        return list;
    }

    public static Map<Integer,City> getmap(){
        return map;
    }

    public static Path getfile(){
        return fileName;
    }
}