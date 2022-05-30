public class EmptySaleException extends Exception{
    private String message;

    public EmptySaleException() {
        message= "Para hacer una venta primero tienes que añadir producto";
    }


    public  String getMessage() {
        return message;
    }
}
