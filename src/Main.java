import java.io.File;
import java.util.*;

public class Main {

    private String directory;
    private Queue<File> directories = new LinkedList<>();
    private HashMap<String, ArrayList<String>> files = new HashMap<>();

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
//                System.out.println(child);
                File file = new File(currentFile, child);
                if (file.isDirectory())
                    directories.add(file);
                else if (file.isFile()) {
//                    if (files.containsKey(file.length()+"")) {
//                        System.out.println(files.get(file.length()+""));
//                        System.out.println(file.getAbsolutePath());
//                    }
                    String key;
                    if (file.getName().contains("."))
                        key = file.length() + "--" + file.getName().substring(file.getName().lastIndexOf('.'));
//                        files.put(file.length() + "--" + file.getName().substring(file.getName().lastIndexOf('.')), file.getAbsolutePath());
                    else
                        key = file.length() + "--";
//                        files.put(file.length() + "--", file.getAbsolutePath());

                    if (files.containsKey(key)) {
                        files.get(key).add(file.getAbsolutePath());
                    } else {
                        files.put(key, new ArrayList<>());
                        files.get(key).add(file.getAbsolutePath());
                    }
                }

            }
        }
        int i=0;
        for (String key :
                files.keySet()) {
            if (files.get(key).size()>1){
                for (String s :
                        files.get(key)) {
                    System.out.print(s+"\t");
                }
                System.out.println();
            }
        }
        System.out.println(files.size());
    }
}
