/**
 * City
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
    /**
     * Main-Method
     * @param args Argument of command line
     * @throws IOException mistake
     * @throws ParseException mistake
     */
    public static void main(String[] args) throws IOException, ParseException {
        CSVParser csvparser = new CSVParser(args);
        Receiver.creationTree();
        csvparser.Reader(args);
        CommandManager comm=new CommandManager();
        comm.start();
    }
}