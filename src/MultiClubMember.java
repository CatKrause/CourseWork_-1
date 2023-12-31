public class MultiClubMember extends Member{
private int membershipPoints;

    @Override
    public String toString() {
        return "MultiClubMember{" +
                "membershipPoints=" + membershipPoints +
                '}';
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public MultiClubMember(char pMemberType, int pMemberID, String pName, double pFees, int membershipPoints) {
        super(pMemberType, pMemberID, pName, pFees);
        this.membershipPoints = membershipPoints;
    }
}
