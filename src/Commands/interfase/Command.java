package Commands.interfase;

import java.io.IOException;
import java.text.ParseException;
import java.util.NoSuchElementException;

/**
 * Interface containing execute and Information
 */
public interface Command {
    /**
     * Fild
     * @param args arg
     * @throws ParseException mistake
     * @throws IOException mistake
     * @throws NoSuchElementException mistake
     */
    void execute(String[] args) throws ParseException, IOException, NoSuchElementException;

    /**
     * Fild for Information
     */
    void Information();
}