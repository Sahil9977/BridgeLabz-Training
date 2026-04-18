
package linked_list;

import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagementSystem {
    private Item head;

    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newItem;
    }

    public void addAtPosition(int pos, String itemName, int itemId, int quantity, double price) {
        if (pos <= 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) temp = temp.next;
        if (temp == null) {
            addAtEnd(itemName, itemId, quantity, price);
            return;
        }
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeByItemId(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByItemId(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println(temp.itemName + ", " + temp.itemId + ", " + temp.quantity + ", " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByItemName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println(temp.itemName + ", " + temp.itemId + ", " + temp.quantity + ", " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void displayAll() {
        Item temp = head;
        if (temp == null) {
            System.out.println("No items in inventory.");
            return;
        }
        System.out.println("ItemName\tItemID\tQuantity\tPrice");
        while (temp != null) {
            System.out.println(temp.itemName + "\t" + temp.itemId + "\t" + temp.quantity + "\t" + temp.price);
            temp = temp.next;
        }
    }

    public void totalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    // Merge sort for sorting by Item Name or Price
    public void sortByName(boolean ascending) {
        head = mergeSortByName(head, ascending);
    }

    private Item mergeSortByName(Item node, boolean ascending) {
        if (node == null || node.next == null) return node;
        Item middle = getMiddle(node);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSortByName(node, ascending);
        Item right = mergeSortByName(nextOfMiddle, ascending);
        return sortedMergeByName(left, right, ascending);
    }

    private Item sortedMergeByName(Item a, Item b, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;
        int cmp = a.itemName.compareToIgnoreCase(b.itemName);
        if ((ascending && cmp <= 0) || (!ascending && cmp > 0)) {
            a.next = sortedMergeByName(a.next, b, ascending);
            return a;
        } else {
            b.next = sortedMergeByName(a, b.next, ascending);
            return b;
        }
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSortByPrice(head, ascending);
    }

    private Item mergeSortByPrice(Item node, boolean ascending) {
        if (node == null || node.next == null) return node;
        Item middle = getMiddle(node);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSortByPrice(node, ascending);
        Item right = mergeSortByPrice(nextOfMiddle, ascending);
        return sortedMergeByPrice(left, right, ascending);
    }

    private Item sortedMergeByPrice(Item a, Item b, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;
        if ((ascending && a.price <= b.price) || (!ascending && a.price > b.price)) {
            a.next = sortedMergeByPrice(a.next, b, ascending);
            return a;
        } else {
            b.next = sortedMergeByPrice(a, b.next, ascending);
            return b;
        }
    }

    private Item getMiddle(Item node) {
        if (node == null) return node;
        Item slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        InventoryManagementSystem inv = new InventoryManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Remove by Item ID\n5. Update Quantity\n6. Search by Item ID\n7. Search by Item Name\n8. Display All\n9. Total Inventory Value\n10. Sort by Name\n11. Sort by Price\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    String n1 = sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    int id1 = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int q1 = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double p1 = sc.nextDouble();
                    inv.addAtBeginning(n1, id1, q1, p1);
                    break;
                case 2:
                    System.out.print("Enter Item Name: ");
                    String n2 = sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    int id2 = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int q2 = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double p2 = sc.nextDouble();
                    inv.addAtEnd(n2, id2, q2, p2);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Item Name: ");
                    String n3 = sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    int id3 = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int q3 = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double p3 = sc.nextDouble();
                    inv.addAtPosition(pos, n3, id3, q3, p3);
                    break;
                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    int rid = sc.nextInt();
                    inv.removeByItemId(rid);
                    break;
                case 5:
                    System.out.print("Enter Item ID: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter new Quantity: ");
                    int uq = sc.nextInt();
                    inv.updateQuantity(uid, uq);
                    break;
                case 6:
                    System.out.print("Enter Item ID to search: ");
                    int sid = sc.nextInt();
                    inv.searchByItemId(sid);
                    break;
                case 7:
                    System.out.print("Enter Item Name to search: ");
                    String sname = sc.nextLine();
                    inv.searchByItemName(sname);
                    break;
                case 8:
                    inv.displayAll();
                    break;
                case 9:
                    inv.totalInventoryValue();
                    break;
                case 10:
                    System.out.print("Sort by Name Ascending (true/false): ");
                    boolean ascName = sc.nextBoolean();
                    inv.sortByName(ascName);
                    break;
                case 11:
                    System.out.print("Sort by Price Ascending (true/false): ");
                    boolean ascPrice = sc.nextBoolean();
                    inv.sortByPrice(ascPrice);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}
