package Commands;

import Collections.StandardOfLiving;
import Parser.Work_with_TreeMap;
import Parser.CSVParser;
import Parser.CSVWriter;
import Parser.Work_with_TreeMap;

import java.io.IOException;
import java.text.ParseException;

/**
 * Class for describing the logic of commands
 */
public class Receiver {
    private final Invoker invoker;

    public Receiver(Invoker invoker){
        this.invoker=invoker;
    }

    public void Help(){
        invoker.getCommandMap().forEach((commandname,command)->command.Information());
    }

    public void Info(){
        CollectionManager.getInfo();
    }

    public void Show(){
        System.out.println(CSVParser.getAllElements());
    }

    /**
     * @param arg
     * @throws ParseException
     */
    public void Insert_null(int arg) throws ParseException {
        CollectionManager.Insert_null(arg);
    }

    /**
     * @param arg
     * @throws ParseException
     */
    public void Update_id(int arg) throws ParseException {
        CollectionManager.Update_id(arg);
    }

    /**
     * @param arg
     */
    public void Remove_key_null(int arg){
        Work_with_TreeMap.Remove_ElementTreeMap(arg);
    }

    public void Clear() {
        CSVParser.getmap().clear();
    }

    /**
     * @param arg
     * @throws IOException
     */
    public void Execute(String arg) throws IOException {
        CollectionManager.Execute(arg);
    }

    public void Exit(){
        System.exit(0);
    }

    public void Save() {
        CSVWriter.Writer(CSVParser.getmap());
        System.out.println("Коллекция сохранена");
    }

    public void History() {
        CollectionManager.History();
    }

    /**
     * @param arg
     */
    public void Remove_greater(int arg) {
        CollectionManager.Remove_greater(arg);
    }

    /**
     * @param arg
     */
    public void Remove_lower(int arg) {
        CollectionManager.Remove_lower(arg);
    }

    public void Max_by_meters_above_sea_level() {
        System.out.println(CollectionManager.Max_by_meters_above_sea_level());
    }

    /**
     * @param arg
     */
    public void Filter_less_than_standard_of_living(StandardOfLiving arg) {
        CollectionManager.Filter_less_than_standard_of_living(arg);
    }

    public void Print_ascending() {
        CollectionManager.Print_ascending();
    }
}