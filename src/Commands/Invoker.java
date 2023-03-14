package Commands;

import Commands.interfase.command;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that execute commands, stores the registered commands and a list of the last called commands
 */
public class Invoker {
    private static ArrayList<String> CommandHistory = new ArrayList<String>();

    private static final HashMap<String,command> commandMap = new HashMap<>();

    /**
     * Method for stores registered commands
     * @param commandName
     * @param command
     */
    public static void register(String commandName, command command){
        commandMap.put(commandName,command);
    }

    /**
     * Method for determining which team should work and writing the team to the history
     * @param commandName
     * @throws ParseException
     * @throws IOException
     */
    public void executeCommand(String[] commandName) throws ParseException, IOException {
        try {
            if (commandName.length>0) {
                command command = commandMap.get(commandName[0]);
                command.execute(commandName);
                CommandHistory.add(commandName[0]);
            } else if (commandName.length==0){
                System.out.println("Вы не ввели команду.");
            }
        } catch (IllegalStateException | NullPointerException ex){
            try {
                if (commandName.length > 1) {
                    command command = commandMap.get(commandName[0] + " " + commandName[1]);
                    command.execute(commandName);
                    CommandHistory.add(commandName[0] + " " + commandName[1]);
                } else {
                    System.out.println("Не существует команды " + commandName[0] + ". Для справки используйте - help");
                }
            } catch (IllegalStateException | NullPointerException exception) {
                System.out.println("Не существует команды " + commandName[0] + " " + commandName[1] + ". Для справки используйте - help");
            }
        }
    }

    public static HashMap<String,command> getCommandMap(){
        return commandMap;
    }

    public static ArrayList<String> getCommandHistory(){
        return CommandHistory;
    }
}