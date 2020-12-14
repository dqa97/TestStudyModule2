package Commons;

import Models.PhoneBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncFileCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String fileNamePhoneNumber = "src/Data/PhoneBook.csv";
    private static final String FILE_HEADER = "phoneNumber,group,name,sex,address";

    public static void writePhoneBookToFileCSV(ArrayList<PhoneBook> listPhoneBook) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNamePhoneNumber);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (PhoneBook phoneBook : listPhoneBook) {
                fileWriter.append(String.valueOf(phoneBook.getPhoneNumber()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getGroup());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getSex());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getAddress());
            }

        } catch (Exception e) {
            System.out.println("Lỗi trong Csv file writer !!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println(" Lỗi khi đóng luồng và đóng bộ nhớ đệm !");
            }
        }
    }

    public static ArrayList<PhoneBook> getFileCSVToListPhoneNumber() {
        BufferedReader br = null;
        ArrayList<PhoneBook> listPhoneBook = new ArrayList<>();
        Path path = Paths.get(fileNamePhoneNumber);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(fileNamePhoneNumber);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileNamePhoneNumber));

            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("phoneNumber")) {
                    continue;
                }
                PhoneBook phoneBook = new PhoneBook();
                phoneBook.setPhoneNumber(Long.parseLong(splitData[0]));
                phoneBook.setGroup(splitData[1]);
                phoneBook.setName(splitData[2]);
                phoneBook.setSex(splitData[3]);
                phoneBook.setAddress(splitData[4]);
                listPhoneBook.add(phoneBook);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return listPhoneBook;
    }
}
