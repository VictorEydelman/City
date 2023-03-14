package Parser;

import Collections.Human;
import Collections.StandardOfLiving;
import Commands.Reader.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Class for getting data about a new collection item
 */
public class CreatCollection {
    /**
     * Method for getting data about a new collection item
     * @return newCity
     */
    public static String[] creatCollection() {
        String id = Integer.toString(CSVParser.getsize()+1);
        while (boolid(id)==false){
            id = Integer.toString(CSVParser.getsize()+1);
        }

        String name = Reader.read("Введите название города: ");
        while (boolName(name)==false){
            name = Reader.read("Введите название города: ");
        }

        String coordinates_X = Reader.read("Введите широту города: ");
        while (boolCoordinatesX(coordinates_X)==false){
            coordinates_X = Reader.read("Введите широту города: ");
        }

        String coordinates_Y = Reader.read("Введите долготу города: ");
        while (boolCoordinatesY(coordinates_Y)==false){
            coordinates_Y = Reader.read("Введите долготу города: ");
        }

        String creationDate = String.valueOf(LocalDate.now());
        while (boolLocalDate(creationDate)==false){
            creationDate = String.valueOf(LocalDate.now());
        }

        String area = Reader.read("Укажите площадь города: ");
        while (boolFloat(area)==false){
            area = Reader.read("Укажите площадь города: ");
        }

        String population = Reader.read("Население города: ");
        while (boolpopulation(population)==false){
            population = Reader.read("Население города: ");
        }

        String metersAboveSeaLevel = Reader.read("Высота город над уровнем моря: ");
        while (boolmeters(metersAboveSeaLevel)==false){
            metersAboveSeaLevel = Reader.read("Высота город над уровнем моря: ");
        }

        String populationDensity = Reader.read("Плотность населения города: ");
        while (boolpopulationDensity(populationDensity)==false){
            populationDensity = Reader.read("Плотность населения города: ");
        }

        String telephoneCode = Reader.read("Код города: ");
        while (booltelephoneCode(telephoneCode)==false){
            telephoneCode = Reader.read("Код города: ");
        }

        String standardOfLiving = Reader.read("Уровень жизни в городе (VERY-HIGH, HIGH, MEDIUM, ULTRA_LOW, NIGHTMARE): ");
        while (boolStandardOfLiving(standardOfLiving)==false){
            standardOfLiving = Reader.read("Уровень жизни в городе (VERY-HIGH, HIGH, MEDIUM, ULTRA_LOW, NIGHTMARE): ");
        }

        String governor = Reader.read("Дата рождения губернатора (формат ввода: dd.mm.yyyy HH:mm:ss): ");
        while (boolHuman(governor)==false){
            governor = Reader.read("Дата рождения губернатора (формат ввода: dd.mm.yyyy HH:mm:ss): ");
        }

        String[] newCity={id,name, coordinates_X, coordinates_Y,
                area, population, metersAboveSeaLevel, populationDensity,
                telephoneCode, standardOfLiving, governor,creationDate};
        return newCity;
    }

    public static boolean boolid(String arg){
        try {
            int n=Integer.parseInt(arg);
            if (n>0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException | NullPointerException ex){
            return false;
        }
    }

    public static boolean boolpopulation(String arg){
        try {
            int n=Integer.parseInt(arg);
            if (n>0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException | NullPointerException ex){
            return false;
        }
    }

    public static boolean boolName(String arg){
        try {
            if (arg!="") {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException ex){
            return false;
        }
    }

    public static boolean boolCoordinatesX(String arg){
        try {
            long n = Long.parseLong(arg);
            if (n<=735) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex){
            return false;
        }
    }

    public static boolean boolCoordinatesY(String arg){
        try {
            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    public static boolean boolLocalDate(String arg){
        try {
            LocalDate.parse(arg);
            return true;
        } catch (DateTimeParseException | NullPointerException ex){
            return false;
        }
    }

    public static boolean boolFloat(String arg){
        try {
            float n = Float.parseFloat(arg);
            if (n>0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException | NullPointerException ex){
            return false;
        }
    }

    public static boolean boolmeters(String arg){
        try {
            Long.parseLong(arg);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }

    public static boolean boolpopulationDensity(String arg){
        try {
            long n = Long.parseLong(arg);
            if (n>0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex){
            return false;
        }
    }

    public static boolean booltelephoneCode(String arg){
        try {
            long n = Long.parseLong(arg);
            if (n>0 && n<=100000) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex){
            return false;
        }
    }

    public static boolean boolStandardOfLiving(String arg){
        try {
            StandardOfLiving.valueOf(arg);
            return true;
        } catch (IllegalArgumentException | NullPointerException ex){
            return false;
        }
    }

    public static boolean boolHuman(String arg){
        try {
            new Human((new SimpleDateFormat("dd.mm.yyyy HH:mm:ss")).parse(arg));
            return true;
        } catch (RuntimeException | ParseException ex) {
            return false;
        }
    }
}