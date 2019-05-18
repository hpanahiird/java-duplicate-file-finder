import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private String directory;
    private Queue<File> directories = new LinkedList<>();
    private HashMap<String, String> files = new HashMap<>();

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
        directories.add(root);
        while (directories.size() != 0) {
            File currentFile = directories.poll();
            for (String child :
                    currentFile.list()) {
                System.out.println(child);
                File file = new File(currentFile, child);
                if (file.isDirectory())
                    directories.add(file);
                else if (file.isFile()) {
//                    if (files.containsKey(file.length()+"")) {
//                        System.out.println(files.get(file.length()+""));
//                        System.out.println(file.getAbsolutePath());
//                    }
                    if (file.getName().contains("."))
                        files.put(file.length() + "--" + file.getName().substring(file.getName().lastIndexOf('.')), file.getAbsolutePath());
                    else
                        files.put(file.length() + "--", file.getAbsolutePath());
                }

            }
        }
        for (String key :
                files.keySet()) {
            System.out.println(key + ":" + files.get(key));
        }
        System.out.println(files.size());
    }
}
