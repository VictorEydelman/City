package Commands;

import Collections.City;
import Collections.StandardOfLiving;
import Commands.ConcreteCommands.Additional.IdToKey;
import Commands.ConcreteCommands.Additional.StandardToInt;
import Parser.*;
import Parser.WorkWithTreeMap;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * Class for describing the logic of commands
 */
public class Receiver {
    private final Invoker invoker;
    private static Map<Integer, City> map;
    private static ZonedDateTime creationDate;
    private static Path path;
    private static int NumberLine;
    private static int CommandNumber=0;

    /**
     * Method for
     * @param invoker invoker
     */
    public Receiver(Invoker invoker){
        this.invoker=invoker;
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
     * Method for get map name
     * @return map.getClass().getName()
     */
    public static String getName(){
        return map.getClass().getName();
    }

    /**
     * Method for creation date
     * @return creationDate
     */
    public static ZonedDateTime getcreatTime(){
        return creationDate;
    }

    /**
     * Method for get map size
     * @return map.size()
     */
    public static int getsize(){
        return map.size();
    }

    /**
     * Method for get all elements
     * @return list of all elements
     */
    public static String getAllElements(){
        String list="";
        for (Map.Entry<Integer,City> entry:map.entrySet()) {
            list += entry.getKey() + " = ";
            list += entry.getValue();
            list += '\n';
        }
        return list;
    }

    /**
     * Method for get map
     * @return map
     */
    public static Map<Integer,City> getmap(){
        return map;
    }

    /**
     * Command implementation help
     */
    public void Help(){
        invoker.getCommandMap().forEach((commandname,command)->command.Information());
    }

    /**
     * Command implementation info
     */
    public void Info(){
        System.out.println("Тип коллекции - "+Receiver.getName()+"\n"
                +"Дата и время инициализации - "+Receiver.getcreatTime()+"\n"+
                "Количество элементов коллекции - "+Receiver.getsize());
    }

    /**
     * Command implementation insert
     * @param arg argument
     * @throws ParseException mistake
     * @throws IOException mistake
     */
    public void Insert(int arg) throws ParseException, IOException {
        ArrayList<String> m = Invoker.getCommandHistory();
        if (m.get(m.size() - CommandNumber-1).equals("execute_script")){
            WorkWithTreeMap.AddToTreeMap(Receiver.getmap(),arg, CreatCollection.creatCollectionExecute());
        } else {
            WorkWithTreeMap.AddToTreeMap(Receiver.getmap(), arg, CreatCollection.creatCollection());
        }
        System.out.println("Новый элемент коллекции создан");
    }

    /**
     * Command implementation update
     * @param arg argument
     * @throws ParseException mistake
     * @throws IOException mistake
     */
    public void Update(int arg) throws ParseException, IOException {
        int key = IdToKey.getKey(map, arg);
        ArrayList<String> m = Invoker.getCommandHistory();
        if (m.get(m.size() - CommandNumber - 1).equals("execute_script")) {
            WorkWithTreeMap.ReplaceTreeMap(map, key, CreatCollection.creatCollectionExecute());
        } else {
            WorkWithTreeMap.ReplaceTreeMap(map, key, CreatCollection.creatCollection());
        }
        System.out.println("Элемент с id равным " + arg + " заменён в коллекции");
    }

    /**
     * Command implementation execute_script
     * @param file file name
     * @throws IOException mistake
     */
    public void Execute(String file) throws IOException {
        Invoker invoker = new Invoker();
        path = Paths.get(file);
        CommandNumber=0;
        try(Scanner scanner = new Scanner(path)) {
           while(scanner.hasNextLine()) {
               ArrayList<String> m = Invoker.getCommandHistory();
               CommandNumber++;
               invoker.executeCommand(scanner.nextLine().trim().split(" "));
               if (m.get(m.size() - 1).equals("insert") || m.get(m.size() - 1).equals("update_id")) {
                   for (int i = 0; i < NumberLine-2; i++) {
                       scanner.nextLine();}
               }
               NumberLine = 0;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException ex){
            System.out.println("Ошибка в вводе команды");
        }
    }

    /**
     * Method for get File
     * @return path
     */
    public static Path getFile(){
        return path;
    }

    /**
     * Method for get number of line
     * @return NumberLine
     */
    public static int getNumberLine(){
        NumberLine++;
        return NumberLine;
    }

    /**
     * Command implementation history
     */
    public void History() {
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
     * Command implementation remove_greater_key
     * @param key key
     */
    public void RemoveGreater(int key) {
        int size = Receiver.getsize();
        for (int i = key + 1; i <= size; i++) {
            WorkWithTreeMap.RemoveElementTreeMap(i);
        }
        System.out.println("Все элементы коллекции с ключами большими " + key + " удалены.");
    }

    /**
     * Command implementation remove_lower_key
     * @param key key
     */
    public void RemoveLower(int key) {
        for (int i = key - 1; i >0; i--) {
            WorkWithTreeMap.RemoveElementTreeMap(i);
        }
        System.out.println("Все элементы коллекции с ключами меньшими " + key + " удалены.");
    }

    /**
     * Command implementation max_by_meters_above_sea_level
     */
    public void MaxMeters() {
        Long max=0L;
        String ElementOfCollection = null;
        for (Map.Entry<Integer, City> entry : map.entrySet()) {
            if ((entry.getValue().getMetersAboveSeaLevel()) > max) {
                max = entry.getValue().getMetersAboveSeaLevel();
                ElementOfCollection = entry.toString();
            }
        }
        System.out.println(ElementOfCollection);
    }

    /**
     * Command implementation filter_less_than_standard_of_living
     * @param standard StandardOfLiving
     */
    public void FilterStandardOfLiving(StandardOfLiving standard) {
        for (Map.Entry<Integer, City> entry : Receiver.getmap().entrySet()) {
            if (StandardToInt.StandToInt(standard) > StandardToInt.StandToInt(entry.getValue().getStandardOfLiving())) {
                System.out.println(entry);
            }
        }
    }

    /**
     * Command implementation print_ascending
     */
    public void PrintAscending() {
        List<Map.Entry<Integer,City>> mappings = new ArrayList<>(map.entrySet());
        mappings.sort(Comparator.comparing(o -> o.getValue().getid()));
        Map<Integer,City> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer,City> entry: mappings) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        for(Map.Entry<Integer,City> entry:linkedHashMap.entrySet()){
            System.out.println(entry.toString());
        }

    }

    /**
     * Command implementation show
     */
    public void Show(){
        System.out.println(getAllElements());
    }

    /**
     * Command implementation remove_key
     * @param arg argument
     */
    public void RemoveKey(int arg){
        WorkWithTreeMap.RemoveElementTreeMap(arg);
    }

    /**
     * Command implementation clear
     */
    public void Clear() {
        map.clear();
    }

    /**
     * Command implementation exit
     */
    public void Exit(){
        System.exit(0);
    }

    /**
     * Command implementation save
     */
    public void Save() {
        CSVWriter.Writer(map);
        System.out.println("Коллекция сохранена");
    }
}