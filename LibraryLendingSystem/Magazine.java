package LibraryLendingSystem;

public class Magazine extends LibraryItem{
    int issueNumber ;
    public Magazine(String Title , int issueNumber) {
        super(Title);
        this.issueNumber = issueNumber;
    }
    public String getType() {
        return "Magazine";
    }
    public int getLoanPeriodDays()  {
        return 7;
    }
}
