package Commands.interfase;

import java.io.IOException;
import java.text.ParseException;

/**
 * Interface containing execute and Information
 */
public interface command {
    void execute(String[] args) throws ParseException, IOException;
    void Information();
}