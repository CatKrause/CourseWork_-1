import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {
    private static String filePath = "C:\\Users\\Катя\\Desktop\\fitnes\\members.csv";
    private static String tempFilePath = "C:\\Users\\Катя\\Desktop\\fitnes\\members.temp";

    public LinkedList<Member> readFile() {
        LinkedList<Member> membersList = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Member member = new Member(data[0].charAt(0), Integer.parseInt(data[1]), data[2], Double.parseDouble(data[3]));
                membersList.add(member);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return membersList;
    }

    public void appendFile(String mem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(mem);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void overwriteFile(LinkedList<Member> m) {
        try (BufferedWriter dell = new BufferedWriter(new FileWriter(tempFilePath))) {
            for (Member member : m) {
                dell.write(member.toString());
                dell.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File tempFile = new File(tempFilePath);
        File originalFile = new File(filePath);

        try {
            Files.copy(tempFile.toPath(), originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл успешно перезаписан");
        } catch (IOException e) {
            System.out.println("Ошибка перезаписи файла");
            e.printStackTrace();
        }
    }
}





