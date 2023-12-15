package pr17;

public class InvalidINNException extends Exception {
    private String innNum;

    public InvalidINNException(String inn){
        super("ИНН "+ inn + " не существует!");
        innNum = inn;
    }
}
