package module_17_oop_principles;

public class Utils extends Utils2{
    int value;

    public Utils(int value) {
        super(value);
        this.value = value;
    }

    public int increment(){
        return value +=4;
    }
    public int decrement(){
        return value -=4;
    }
}
