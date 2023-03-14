package Commands;

import Commands.ConcreteCommands.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class for recording which commands exist and reading which command was received at the input
 */
public class CommandManager {
    /**
     * Method for recording which commands exist and reading which command was received at the input
     * @throws IOException
     */
     public void start() throws IOException {
        Invoker invoker =new Invoker();
        Receiver r = new Receiver(invoker);
        invoker.register("help",new Help(r));
        invoker.register("info",new Info(r));
        invoker.register("show", new Show(r));
        invoker.register("insert null", new Insert_null(r));
        invoker.register("update id", new Update_id(r));
        invoker.register("remove_key null", new Remove_key_null(r));
        invoker.register("clear", new Clear(r));
        invoker.register("save", new Save(r));
        invoker.register("execute_script", new Execute_script_file_name(r));
        invoker.register("exit", new Exit(r));
        invoker.register("history", new History(r));
        invoker.register("remove_greater_key null", new Remove_greater_key_null(r));
        invoker.register("remove_lower_key null", new Remove_lower_key_null(r));
        invoker.register("max_by_meters_above_sea_level", new Max_by_meters_above_sea_level(r));
        invoker.register("filter_less_than_standard_of_living", new Filter_less_than_standard_of_living(r));
        invoker.register("print_ascending", new Print_ascending(r));

        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                invoker.executeCommand(sc.nextLine().trim().split(" "));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
     }
}