package Collections;
public class Coordinates {
    private long x; //Максимальное значение поля: 735
    private Integer y; //Поле не может быть null
    public Coordinates(long x, Integer y){
        this.x=x;
        this.y=y;
    }

    public long getX(){
        return x;
    }

    public Integer getY(){
        return y;
    };
}
