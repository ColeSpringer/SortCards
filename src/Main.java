import java.util.Scanner;

import Library.Hand;
import UI.UserInterface;
public class Main {

    public static void main(String[] args) {
        
        UserInterface userInterface = new UserInterface(new Scanner(System.in), new Hand());
        userInterface.start();
    }
}
