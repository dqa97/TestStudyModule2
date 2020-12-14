package View;

import Commons.FuncFileCSV;
import Models.PhoneBook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<PhoneBook> listPhoneNumber = new ArrayList<>();

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        System.out.println(
                        "1. Xem danh sách.\n" +
                        "2. Thêm mới.\n" +
                        "3. Cập nhật.\n" +
                        "4. Xóa.\n" +
                        "5. Tìm kiếm.\n" +
                        "6. Đọc file.\n" +
                        "7. Ghi file.\n" +
                        "8. Thoát.\n" +
                        "Chọn chức năng:\n ");
        Scanner sc = new Scanner(System.in);
        String choose = sc.nextLine();
        switch (choose) {
            case "1":
                showList();
                break;
            case "2":
                addNew();
                break;
            case "3":
                update();
                break;
            case "4":
                delete();
                break;
            case "5":
                search();
                break;
            case "6":
                readFile();
                break;
            case "7":
                writeFile();
                break;
            case "8":
                System.exit(0);
                break;
            default:
                System.out.println("Lỗi! Hãy nhập lại ...");
                sc.nextLine();
                displayMainMenu();
        }
    }

    private static void writeFile() {

    }

    private static void readFile() {

    }

    private static void search() {

    }

    private static void delete() {
        listPhoneNumber = FuncFileCSV.getFileCSVToListPhoneNumber();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên người cần xóa");
        String searchName = checkInputInt(sc);
        for (int i = 0; i < listPhoneNumber.size(); i++) {
            if (listPhoneNumber.get(i).getName().equals(searchName)){
                listPhoneNumber.remove(i);
            }
        }
        FuncFileCSV.writePhoneBookToFileCSV(listPhoneNumber);
        System.out.println("Xóa danh bạ thành công");
        displayMainMenu();

    }

    private static void update() {
        listPhoneNumber = FuncFileCSV.getFileCSVToListPhoneNumber();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên người cần sửa: ");
        String searchName = checkInputInt(sc);
        System.out.println("1.Sửa số điện thoại.\n" +
                "2.Sửa Nhóm.\n" +
                "3.Sửa tên.\n" +
                "4.Sửa giới tính.\n" +
                "5.Sửa địa chỉ.\n" +
                "6. Exit");
        for (PhoneBook phoneBook : listPhoneNumber) {
            if (phoneBook.getName().equals(searchName)) {
                String choose = sc.nextLine();
                switch (choose) {
                    case "1":
                        System.out.println("Sửa số điện thoại");
                        phoneBook.setPhoneNumber(Long.parseLong(sc.nextLine()));
                        break;
                    case "2":
                        System.out.println("Sửa nhóm");
                        phoneBook.setGroup(sc.nextLine());
                        break;
                    case "3":
                        System.out.println("Sửa Họ Tên");
                        phoneBook.setName(sc.nextLine());
                        break;
                    case "4":
                        System.out.println("Sửa giới tính");
                        phoneBook.setSex(sc.nextLine());
                        break;
                    case "5":
                        System.out.println("Sửa địa chỉ");
                        phoneBook.setAddress(sc.nextLine());
                    case "6":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lỗi. Vui lòng nhập lại");
                        sc.nextLine();
                }
            }
        }
        FuncFileCSV.writePhoneBookToFileCSV(listPhoneNumber);
        System.out.println("Sửa đổi thành công");
        displayMainMenu();
    }

    private static void addNew() {
        listPhoneNumber = FuncFileCSV.getFileCSVToListPhoneNumber();
        Scanner sc = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        System.out.println("Nhập số điện thoại ");
        phoneBook.setPhoneNumber(Long.parseLong(sc.nextLine()));
        System.out.println("Nhập nhóm ");
        phoneBook.setGroup(sc.nextLine());
        System.out.println("Nhập Họ Tên ");
        phoneBook.setName(sc.nextLine());
        System.out.println("Nhập giới tính ");
        phoneBook.setSex(sc.nextLine());
        System.out.println("Nhập địa chỉ ");
        phoneBook.setAddress(sc.nextLine());
        FuncFileCSV.writePhoneBookToFileCSV(listPhoneNumber);
        System.out.println("Hoàn thành thêm danh bạ");
        listPhoneNumber.add(phoneBook);
        FuncFileCSV.writePhoneBookToFileCSV(listPhoneNumber);
        sc.nextLine();
        displayMainMenu();
    }

    private static void showList() {
        listPhoneNumber = FuncFileCSV.getFileCSVToListPhoneNumber();

        for (PhoneBook phoneBook : listPhoneNumber) {
            System.out.println("-----------------------------------");
            System.out.println("Số điện thoại: " + phoneBook.getPhoneNumber());
            System.out.println("Nhóm: " + phoneBook.getGroup());
            System.out.println("Họ Tên: " + phoneBook.getName());
            System.out.println("Giới tính: " + phoneBook.getSex());
            System.out.println("Địa chỉ: " + phoneBook.getAddress());
            System.out.println("-----------------------------------");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhấn Enter để tiếp tục...");
        sc.nextLine();
        displayMainMenu();
    }

    private static String checkInputInt(Scanner input) {
        boolean check = true;
        String name = String.valueOf(-1);
        while (check) {
            try {
                name = String.valueOf(input.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println(" Hãy nhập lại ");
            }
        }
        return name;
    }
}
