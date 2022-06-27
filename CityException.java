public class CityException extends Exception{
    private String check;
    CityException(String check){
        this.check = check;
    }

    public String toString() { System.out.println("City not found"); }
}
