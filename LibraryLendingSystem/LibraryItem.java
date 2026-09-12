package LibraryLendingSystem;

abstract class LibraryItem {

    private String ID;
    private String Title;
    private boolean borrowed;

    private static int totalItemsCreated = 0;


   private static int nextNumber = 1;


    public LibraryItem (String Title ) {
        if (Title == null || Title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        } else  {
            this.Title = Title;
            this.ID = "ITEM-" + nextNumber;
            nextNumber++;
            this.borrowed = false;
        }
        totalItemsCreated++ ;
    }

    public String getID() {
        return ID;
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        if (Title == null || Title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        } else  {
            Title = title;
        }
    }
    public boolean isBorrowed() {
        return borrowed;
    }
    public static int getNextNumber() {
        return nextNumber;
    }
    public static int getTotalItemsCreated() {
        return totalItemsCreated;
    }
    public void markBorrowed() {
        this.borrowed = true;
    }
    public void markReturned() {
        this.borrowed = false;
    }
    public void displayInfo() {
        System.out.println(getID()
                + " | " + getTitle()
                + " | " + getType()
                + " | loan: " + getLoanPeriodDays()
                + " days" + " | "
                + (isBorrowed() ? "OUT" : "available"));
    }
    public abstract int getLoanPeriodDays(); // how many days this item can be borrowed
    public abstract String getType(); // "Book", "Magazine", or "DVD"


}
