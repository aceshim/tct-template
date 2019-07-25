import java.io.*;
public class IOTemplate {
    public static void main(String args[]) {
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("input.txt");
            out = new FileWriter("output.txt");

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
    }
    
    public static void mkdir(String path) {

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