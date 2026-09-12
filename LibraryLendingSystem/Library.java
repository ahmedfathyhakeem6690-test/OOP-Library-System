package LibraryLendingSystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
    private Map <String, LibraryItem> catalog;
    private Map<String, Member> members;
    private Set<String> borrowedIds;

    public Library() {
        catalog = new HashMap<>();
        members = new HashMap<>();
        borrowedIds = new HashSet<>();

    }

    public void addItem(LibraryItem item) {
        catalog.put(item.getID(), item);
    }
    public void addMember(Member m) {
        members.put(m.getMemberId(), m);
    }
    public Map<String, LibraryItem> getCatalog() {
        return catalog;
    }
    public Map<String, Member> getMembers() {
        return members;
    }
    public Set<String> getBorrowedIds() {
        return borrowedIds;
    }

    public void borrowItem(String memberId, String itemId) throws LibraryException {
        Member member = members.get(memberId);
        LibraryItem item = catalog.get(itemId);
        if (member == null || item == null) {
            throw new LibraryException("Member or item not found");
        }

        if (item.isBorrowed()) {
            throw new LibraryException("Item " + itemId + " is already out");
        }

        if (!member.canBorrowMore()) {
            throw new LibraryException("Member has reached borrowing limit");
        }

        item.markBorrowed();
        member.addBorrowedItem(item);
        borrowedIds.add(itemId);
    }
    public void returnItem(String memberId, String itemId) throws LibraryException {
        Member member = members.get(memberId);
        LibraryItem item = catalog.get(itemId);
        if (member == null || item == null) {
            throw new LibraryException("Member or item not found");
        }

        if (!member.getBorrowedItems().contains(item)) {
            throw new LibraryException("This member did not borrow this item");
        }

        item.markReturned();
        member.removeBorrowedItem(item);
        borrowedIds.remove(itemId);

    }
    public void listCatalog() {
        for (LibraryItem item : catalog.values()) {
            item.displayInfo();
        }
    }
    public void printReport() {
        System.out.println("---------- REPORT ----------");
        System.out.println("Total items : " + catalog.size());
        System.out.println("Currently out : " + borrowedIds.size());
        System.out.println("Borrowed ids : " + borrowedIds);

        Map<String, Integer> countByType = new HashMap<>();
        for (LibraryItem item : catalog.values()) {
            String type = item.getType();
            countByType.put(type, countByType.getOrDefault(type, 0) + 1);
        }
        System.out.println("Items by type : " + countByType);

        System.out.println("Total created : " + LibraryItem.getTotalItemsCreated());
        System.out.println("----------------------------");

    }



}

