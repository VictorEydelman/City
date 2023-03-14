package Commands;

import Collections.City;
import Collections.StandardOfLiving;
import Commands.ConcreteCommands.Additional.Standard_to_int;
import Commands.ConcreteCommands.Additional.id_to_key;

import Parser.Work_with_TreeMap;
import Parser.CSVParser;
import Parser.CreatCollection;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

import static Collections.StandardOfLiving.*;
/**
 * Class for describing the logic of commands (used in case of insufficiency Receiver)
 */
public class CollectionManager {

    public static void getInfo(){
        System.out.println("Тип коллекции - "+CSVParser.getName()+"\n"
                +"Дата и время инициализации - "+CSVParser.getcreatTime()+"\n"+
                "Количество элементов коллекции - "+CSVParser.getsize());
    }

    /**
     * @param arg
     * @throws ParseException
     */
    public static void Insert_null(int arg) throws ParseException {
        //String[] nullCollection={"0",null,"0","0","0000-01-01","0","0","0","0","0","MEDIUM","01.01.0000"};
        Work_with_TreeMap.Add_to_TreeMap(CSVParser.getmap(),arg,CreatCollection.creatCollection());
        System.out.println("Нулевой элемент коллекции создан");
    }

    /**
     * @param arg
     * @throws ParseException
     */
    public static void Update_id(int arg) throws ParseException {
        int key = id_to_key.getKey(CSVParser.getmap(), arg);
        Work_with_TreeMap.Replace_TreeMap(CSVParser.getmap(), key, CreatCollection.creatCollection());
        System.out.println("Элемент с id равным " + arg + " заменён в коллекции");
    }

    /**
     * @param file
     * @throws IOException
     */
    public static void Execute(String file) throws IOException {
        Invoker invoker = new Invoker();
        String fileName = file;
        Path path = Paths.get(fileName);
        try(Scanner scanner = new Scanner(path)) {
            while(scanner.hasNextLine()) {
                invoker.executeCommand(scanner.nextLine().trim().split(" "));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     */
    public static void History() {
        ArrayList<String> History=Invoker.getCommandHistory();
        if (History.size()>10){
            for (int i=History.size()-1;i>History.size()-11;i--){
                System.out.println(History.get(i)+" ");
            }
        } else {
            for (int i=History.size()-1;i>=0;i--){
                System.out.println(History.get(i)+" ");
            }
        }
        System.out.println();
    }

    /**
     * @param key
     */
    public static void Remove_greater(int key) {
        int size = CSVParser.getsize();
        for (int i = key + 1; i <= size; i++) {
            Work_with_TreeMap.Remove_ElementTreeMap(i);
        }
        System.out.println("Все элементы коллекции с ключами большими " + key + " удалены.");
    }

    /**
     * @param key
     */
    public static void Remove_lower(int key) {
        for (int i = key - 1; i >0; i--) {
            Work_with_TreeMap.Remove_ElementTreeMap(i);
        }
        System.out.println("Все элементы коллекции с ключами меньшими " + key + " удалены.");
    }

    /**
     * @return
     */
    public static int Max_by_meters_above_sea_level() {
        Long max=0L;
        int key = 0;
        for (Map.Entry<Integer, City> entry : CSVParser.getmap().entrySet()) {
            if ((entry.getValue().getMetersAboveSeaLevel()) > max) {
                max = entry.getValue().getMetersAboveSeaLevel();
                key=entry.getKey();
            }
        }
        return key;
    }

    /**
     * @param standard
     */
    public static void Filter_less_than_standard_of_living(StandardOfLiving standard) {
        for (Map.Entry<Integer, City> entry : CSVParser.getmap().entrySet()) {
            if (Standard_to_int.Stand_to_int(standard) > Standard_to_int.Stand_to_int(entry.getValue().getStandardOfLiving())) {
                System.out.println(entry);
            }
        }
    }

    public static void Print_ascending() {
        Map<Integer,City> map=CSVParser.getmap();
        List<Map.Entry<Integer,City>> mappings = new ArrayList<>(map.entrySet());
        Collections.sort(mappings, Comparator.comparing(o->o.getValue().getid()));
        Map<Integer,City> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer,City> entry: mappings) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(linkedHashMap);
    }
}