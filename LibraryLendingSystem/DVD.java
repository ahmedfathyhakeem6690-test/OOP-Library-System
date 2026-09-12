package LibraryLendingSystem;

public class DVD extends LibraryItem{

    int runtimeMinutes ;
    public DVD(String Title , int runtimeMinutes) {
        super(Title);
        if (runtimeMinutes <= 0 ) {
            throw new IllegalArgumentException("runtimeMinutes cannot be negative");
        }else {
            this.runtimeMinutes = runtimeMinutes;
        }
    }
    public String getType() {
        return "DVD";
    }
    public int getLoanPeriodDays()  {
        return 3;
    }

}
