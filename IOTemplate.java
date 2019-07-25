import java.io.*;
public class IOTemplate {
    
    public static void copy(String from, String to) {
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader(from);
            out = new FileWriter(to);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static String getPath(String path) {
        File inputfile = new File(path);
        String inputPath = inputFile.getAbsolutePath();
        System.out.println("dataset path: " + inputPath);
        return inputPath;
    }

    public static void getFiles(String path) {
        // https://stackoverflow.com/questions/2056221/recursively-list-files-in-java
        Files.walk(Paths.get(path)).filter(Files::isRegularFile).forEach(System.out::println);
        // Stream operation https://www.geeksforgeeks.org/stream-in-java/
    }
    
    public static void mkdir(String path) {
        if (path == null) return;

        File d = new File(path);
        // mkdir creates a directory, return true on success and false. 
        //mkdirs creates both a directory and all the parents of the directory
        d.mkdirs(); 
    }

    public static void ls (String pwd) {
        File file = null;
        String[] paths;

        if (pwd == null) return;

        try {
            file = new File(pwd);
            paths = file.list();

            for(String path:paths) {
                System.out.println(path);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}