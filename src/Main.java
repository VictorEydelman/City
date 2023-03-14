/**
 * @author Viktor Eydelman
 */

import Parser.CSVParser;
import java.io.IOException;
import java.text.ParseException;
import Commands.*;

/**
 * Main class
 */

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        CSVParser csvparser = new CSVParser(args);
        csvparser.creationTree();
        csvparser.Reader(args);
        CommandManager comm=new CommandManager();
        comm.start();
    }
}