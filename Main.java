import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        bunglow b = new bunglow(3,"gwalior",4000);
        b.getCost();
        b.calculateEstimate();

    }
}