
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    static int counter = 0;
    final private Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        while (!reader.hasNextInt()) {
            System.out.println("Введите целое число:");
            reader.next();
        }
        return reader.nextInt();
    }

    private void printClubOptions() {
        System.out.println("1) Клуб Меркурий\n2) Клуб Нептун\n3) Клуб Юпитер\n4) Несколько клубов");
    }

    public int getChoice() {
        int choice;
        System.out.println("ДОБРО ПОЖАЛОВАТЬ В ОЗОН ФИТНЕС-ЦЕНТР");
        System.out.println("================================");
        System.out.print("1) Добавить участника\n2) Удалить информацию об участнике\n3) Показать информацию об участнике\nПожалуйста, выберите опцию (или введите -1 для выхода): ");
        choice = getIntInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> membersList) {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;

        printClubOptions();
        System.out.println("Введите идентификатор клуба для посетителя:");
        club = getIntInput();

        if (club < 1 || club > 4) {
            return "Ошибка: Неверный идентификатор клуба";
        }
        memberID = generateMemberID();
        mbr = addMember(club, memberID, membersList);
        mem = mbr.toString();
        System.out.println("Посетитель успешно добавлен.");

        return mem;
    }

    private Member addMember(int club, int memberID, LinkedList<Member> membersList) {
        Member mbr = null;
        switch (club) {
            case 1:
            case 2:
            case 3:
                mbr = addSingleClubMember(club, memberID, membersList);
                break;
            case 4:
                // Некоторая логика создания объекта Member для club == 4
                mbr = new Member('S', memberID, "Имя", 0.0); // Пример, адаптируйте под вашу логику
                membersList.add(mbr);
                break;
            default:
                throw new IllegalArgumentException("Неверный идентификатор клуба");
        }
        return mbr;
    }

    private Member addSingleClubMember(int club, int memberID, LinkedList<Member> membersList) {
        double fees = calculateFees(club);
        SingleClubMember singleClubMember = new SingleClubMember('S', memberID, "Имя", fees, club);
        membersList.add(singleClubMember);
        return singleClubMember;
    }

    private double calculateFees(int club) {
        switch (club) {
            case 1:
                return 900;
            case 2:
                return 950;
            case 3:
                return 1000;
            default:
                throw new IllegalArgumentException("Неверный идентификатор клуба");
        }
    }

    private int generateMemberID() {
        return counter++;
    }

    public void removeMember(LinkedList<Member> membersList) {
        System.out.println("Введите идентификатор пользователя, данные которого хотите удалить:");
        int memberIDToRemove = getIntInput();
        boolean removed = false;
        Iterator<Member> iterator = membersList.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getMemberID() == memberIDToRemove) {
                iterator.remove();
                System.out.println("Данные пользователя с идентификатором " + memberIDToRemove + " удалены.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Пользователь с идентификатором " + memberIDToRemove + " не найден.");
        }
    }

    public void printMemberInfo(LinkedList<Member> membersList) {
        System.out.println("Введите идентификатор пользователя, чтобы получить информацию:");
        int memberIDToPrint = getIntInput();
        boolean info = false;
        Iterator<Member> iterator = membersList.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getMemberID() == memberIDToPrint) {
                System.out.println(member.toString());
                System.out.println("Данные пользователя с идентификатором " + memberIDToPrint + " найдены.");
                info = true;
                break;
            }
        }
        if (!info) {
            System.out.println("Пользователь с идентификатором " + memberIDToPrint + " не найден.");
        }
    }
}




