package LibraryLendingSystem;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId ;
    private String name ;
    private int maxAllowed;

    public  Member(String memberId, String name, int maxAllowed) {
        if (memberId == null || memberId.isEmpty() || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("memberId cannot be null or empty");
        } else {
            this.memberId = memberId;
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }else {
            this.name = name;
        }
        if (maxAllowed <= 0) {
            throw new IllegalArgumentException("maxAllowed cannot be negative");
        }else {
            this.maxAllowed = maxAllowed;
        }

    }

    List<LibraryItem> borrowedItems  = new ArrayList<>();

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public int getBorrowedCount() {
        return borrowedItems.size();
    }
    public boolean canBorrowMore() {
        return borrowedItems.size() < maxAllowed;
    }
    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }
    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }
    public String getName() {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        } else {
            return name;
        }
    }
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }else {
            this.name = name;
        }
    }
    public String getMemberId() {
        return memberId;
    }
    public int getMaxAllowed() {
        return maxAllowed;

    }
    public void setMaxAllowed(int maxAllowed) {
        if (maxAllowed <= 0) {
            throw new IllegalArgumentException("maxAllowed must be greater than 0");
        } else {
            this.maxAllowed = maxAllowed;
        }
    }

}
