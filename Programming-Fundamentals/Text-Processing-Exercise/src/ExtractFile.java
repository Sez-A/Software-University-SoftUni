import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        int fileNameIndex = path.lastIndexOf('\\');
        int extensionIndex = path.indexOf('.');

        String fileName = path.substring(fileNameIndex + 1,extensionIndex);
        String extension = path.substring(extensionIndex + 1);

        System.out.println(String.format("File name: %s",fileName));
        System.out.println(String.format("File extension: %s",extension));
    }
}
