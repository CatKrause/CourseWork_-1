public class Member {
    private char memberType;
    private int memberID;
    private String name;
    private  double fees;

    @Override
    public String toString() {
        return "Member{" +
                "memberType=" + memberType +
                ", memberID=" + memberID +
                ", name='" + name + '\'' +
                ", fees=" + fees +
                '}';
    }

    public Member(char pMemberType, int pMemberID, String pName, double pFees) {
        this.memberType = pMemberType;
        this.memberID = pMemberID;
        this.name = pName;
        this.fees = pFees;
    }

    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public char getMemberType() {
        return memberType;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public double getFees() {
        return fees;
    }
}
