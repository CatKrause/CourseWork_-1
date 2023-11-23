public class SingleClubMember extends Member {
    @Override
    public String toString() {
        return "SingleClubMember{" +
                super.toString() +
                "club=" + club +
                '}';
    }

    private int club;

    public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int club) {
        super(pMemberType, pMemberID, pName, pFees);
        this.club = club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    public int getClub() {
        return club;
    }
}

