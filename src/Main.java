import java.io.File;
import java.util.Scanner;

public class Main {

    private String directory;

    public static void main(String[] args) {
        System.out.println("Hello");
        (new Main()).getInputs();
    }

    private void getInputs() {
        System.out.println("Please enter your directory: ");
        Scanner scanner = new Scanner(System.in);
        File root;
        do {
            this.directory = scanner.nextLine();
            root = new File(directory);
            if (root.isFile())
                System.out.println("\033[0;33m" + "is file" + "\033[0m");
            else if (root.isDirectory())
                System.out.println("is dir");
            else
                System.out.println("\033[0;31m" + "nothing" + "\033[0m");
        } while (!root.isDirectory());

    }
}
