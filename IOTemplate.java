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

    public static String getPath(String file) {
        File inputfile = new File(file);
        String inputPath = inputFile.getAbsolutePath();
        System.out.println("dataset path: " + inputPath);
        return inputPath;
    }

    public static void getFiles(String file) {
        // https://stackoverflow.com/questions/2056221/recursively-list-files-in-java
    }
}