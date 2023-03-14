package Commands.ConcreteCommands;

import Commands.Receiver;
import Commands.interfase.command;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 * Class for a command that reads commands from a specified file and sends them for execution
 */
public class Execute_script_file_name implements command {
    private final Receiver receiver;
    public Execute_script_file_name(Receiver receiver){
        this.receiver=receiver;
    }

    /**
     * @param args
     * @throws IOException
     */
    @Override
    public void execute(String[] args) throws IOException {
        try {
            if (args.length == 2) {
                receiver.Execute(args[1]);
            } else {
                System.out.println("Некорректное количество аргументов. Для справки напишите help.");
            }
        } catch (StackOverflowError ex){
            System.out.println("Обнаружен выход за переделы стека.");
        } catch (NoSuchFileException ex) {
            System.out.println("Не введено название файла");
        }
    }

    @Override
    public void Information(){
        System.out.println("Команда execute_script - она позволяет считывать команды из файла. Формат ввода: execute_script file_name");
    }
}