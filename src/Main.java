import java.util.Scanner;

public class Main {

    String directory;

    public static void main(String[] args) {
        System.out.println("Hello");
        (new Main()).getInputs();
    }

    void getInputs(){
        System.out.println("Please enter your directory: ");
        Scanner scanner = new Scanner(System.in);
        this.directory = scanner.nextLine();
    }
}
