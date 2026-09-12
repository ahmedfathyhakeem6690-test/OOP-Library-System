package LibraryLendingSystem;

public class Book extends LibraryItem{
    String Author;
    int pages;

     public Book(String Title ,String Author, int pages ) {
        super(Title);
        this.Author = Author;
        this.pages = pages;

    }
    public String getType() {
        return "Book";
    }
    public int getLoanPeriodDays()  {
        return 21;
    }
}
