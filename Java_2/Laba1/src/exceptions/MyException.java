package exceptions;

public class MyException extends Exception{
    private int exceptionNumber;
    public  int getNumb() {return exceptionNumber;}
    public void purpose(){
        System.out.println("Please enter correct data ");
    }
    public MyException(String message, int num) {
        super(message);
        exceptionNumber = num;
    }

}
