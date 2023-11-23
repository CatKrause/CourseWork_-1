import java.util.LinkedList;

public class JavaProject {
    public static void main(String[] args) {
        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        LinkedList<Member> members = new LinkedList<>();
        int choice;

        do {
            choice = mm.getChoice();
            switch (choice) {
                case 1:
                    mem = mm.addMembers(members);
                    fh.appendFile(mem);
                    break;
                case 2:
                    mm.removeMember(members);
                    fh.overwriteFile(members);
                    break;
                case 3:
                    mm.printMemberInfo(members);
                    break;
                case -1:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        } while (choice != -1);
    }
}