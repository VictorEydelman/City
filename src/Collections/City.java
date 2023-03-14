package Collections;

import java.text.SimpleDateFormat;

public class City {
        private int id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным
        private String name; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private Float area; //Значение поля должно быть больше 0, Поле не может быть null
        private int population; //Значение поля должно быть больше 0
        private Long metersAboveSeaLevel;
        private long populationDensity; //Значение поля должно быть больше 0
        private Long telephoneCode; //Значение поля должно быть больше 0, Максимальное значение поля: 100000
        private StandardOfLiving standardOfLiving; //Поле не может быть null
        private Human governor; //Поле не может быть null

        public City(int id, String name, Coordinates coordinates, java.time.LocalDate creationDate, Float area,
                    int population, long metersAboveSeaLevel, long populationDensity, long telephoneCode,
                    StandardOfLiving standardOfLiving, Human governor){
                this.id=id;
                this.name=name;
                this.coordinates=coordinates;
                this.creationDate=creationDate;
                this.area=area;
                this.population=population;
                this.metersAboveSeaLevel=metersAboveSeaLevel;
                this.populationDensity=populationDensity;
                this.telephoneCode=telephoneCode;
                this.standardOfLiving=standardOfLiving;
                this.governor=governor;
        }

        @Override
        public String toString() {
                return "City [id=" + id + ", name=" + name + ", coordinates.x=" + coordinates.getX()
                        + ", coordinates.y=" + coordinates.getY() + ", creationDate="
                        + creationDate + ", area="  + area + ", population=" + population + ", metersAboveSeaLevel="
                        + metersAboveSeaLevel + ", populationDensity=" + populationDensity + ", telephoneCode="
                        + telephoneCode + ", standardOfLiving="+ standardOfLiving + ", governor="
                        + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(governor.getBirthday()) + "]";
        }

        public String String() {
                return  "," + name + "," + coordinates.getX() + "," + coordinates.getY()
                        + ","  + area + "," + population + ","
                        + metersAboveSeaLevel + "," + populationDensity + "," + telephoneCode
                        + ","+ standardOfLiving + "," + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(governor.getBirthday());
        }

        public static String NameCity() {
                return  "key,name,coordinates.getX(),coordinates.getY(),area,population," +
                        "metersAboveSeaLevel,populationDensity,telephoneCode,standardOfLiving," +
                        "governor.getBirthday()";
        }

        public int getid(){
                return id;
        }

        public String getname(){
                return name;
        }

        public Coordinates getCoordinates(){
                return coordinates;
        }

        public java.time.LocalDate getCreationDate(){
                return creationDate;
        }

        public Float getarea(){
                return area;
        }

        public int getPopulation(){
                return population;
        }

        public Long getMetersAboveSeaLevel(){
                return metersAboveSeaLevel;
        }

        public long getTelephoneCode(){
                return telephoneCode;
        }

        public long getpopulationDensity(){
                return populationDensity;
        }

        public StandardOfLiving getStandardOfLiving(){
                return standardOfLiving;
        }

        public Human getGovernor(){
                return governor;
        }

}