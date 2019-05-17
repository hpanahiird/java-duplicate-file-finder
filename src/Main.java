import java.io.File;
import java.util.Scanner;

public class Main {

    private String directory;

    public static void main(String[] args) {
        System.out.println("Hello");
        (new Main()).getInputs();
    }

    private void getInputs(){
        System.out.println("Please enter your directory: ");
        Scanner scanner = new Scanner(System.in);
        this.directory = scanner.nextLine();
        File root = new File(directory);
        if (root.isFile())
            System.out.println("is file");
        else if (root.isDirectory())
            System.out.println("is dir");
        else
            System.out.println("nothing");
    }
}
