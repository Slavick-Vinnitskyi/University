public class MyException extends Exception{
    private int wrongNumber;
    public  int getNumb(){return wrongNumber;}
    public void purpose(){
        System.out.println("Please enter correct data ");
    }
    public MyException(String message, int num){

        super(message);
        wrongNumber = num;
    }

}
