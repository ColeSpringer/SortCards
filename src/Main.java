import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        
        UserInterface userInterface = new UserInterface(new Scanner(System.in), new Hand());
        userInterface.start();
    }
}
