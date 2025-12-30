// Q7_SocialMediaFriendConnections.java
// Singly Linked List: Social Media Friend Connections
package linked_list;

import java.util.ArrayList;
import java.util.Scanner;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMediaFriendConnections {
    private User head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    public User searchByUserId(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public User searchByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int userId1, int userId2) {
        User u1 = searchByUserId(userId1);
        User u2 = searchByUserId(userId2);
        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }
        if (!u1.friendIds.contains(userId2)) u1.friendIds.add(userId2);
        if (!u2.friendIds.contains(userId1)) u2.friendIds.add(userId1);
        System.out.println("Friend connection added.");
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User u1 = searchByUserId(userId1);
        User u2 = searchByUserId(userId2);
        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }
        u1.friendIds.remove(Integer.valueOf(userId2));
        u2.friendIds.remove(Integer.valueOf(userId1));
        System.out.println("Friend connection removed.");
    }

    public void displayFriends(int userId) {
        User user = searchByUserId(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print("Friends of " + user.name + ": ");
        if (user.friendIds.isEmpty()) {
            System.out.println("No friends.");
            return;
        }
        for (int fid : user.friendIds) {
            User f = searchByUserId(fid);
            if (f != null) System.out.print(f.name + " (" + f.userId + ") ");
        }
        System.out.println();
    }

    public void findMutualFriends(int userId1, int userId2) {
        User u1 = searchByUserId(userId1);
        User u2 = searchByUserId(userId2);
        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }
        ArrayList<Integer> mutual = new ArrayList<>();
        for (int fid : u1.friendIds) {
            if (u2.friendIds.contains(fid)) mutual.add(fid);
        }
        if (mutual.isEmpty()) {
            System.out.println("No mutual friends.");
            return;
        }
        System.out.print("Mutual friends: ");
        for (int fid : mutual) {
            User f = searchByUserId(fid);
            if (f != null) System.out.print(f.name + " (" + f.userId + ") ");
        }
        System.out.println();
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " (" + temp.userId + ") has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    public void displayAllUsers() {
        User temp = head;
        if (temp == null) {
            System.out.println("No users found.");
            return;
        }
        System.out.println("UserID\tName\tAge");
        while (temp != null) {
            System.out.println(temp.userId + "\t" + temp.name + "\t" + temp.age);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaFriendConnections sm = new SocialMediaFriendConnections();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add User\n2. Add Friend Connection\n3. Remove Friend Connection\n4. Find Mutual Friends\n5. Display Friends\n6. Search by Name\n7. Search by User ID\n8. Count Friends\n9. Display All Users\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sm.addUser(uid, name, age);
                    break;
                case 2:
                    System.out.print("Enter User ID 1: ");
                    int u1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int u2 = sc.nextInt();
                    sm.addFriendConnection(u1, u2);
                    break;
                case 3:
                    System.out.print("Enter User ID 1: ");
                    int r1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int r2 = sc.nextInt();
                    sm.removeFriendConnection(r1, r2);
                    break;
                case 4:
                    System.out.print("Enter User ID 1: ");
                    int m1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int m2 = sc.nextInt();
                    sm.findMutualFriends(m1, m2);
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    int fid = sc.nextInt();
                    sm.displayFriends(fid);
                    break;
                case 6:
                    System.out.print("Enter Name to search: ");
                    String sname = sc.nextLine();
                    User foundByName = sm.searchByName(sname);
                    if (foundByName != null) {
                        System.out.println("Found: " + foundByName.userId + ", " + foundByName.name + ", " + foundByName.age);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter User ID to search: ");
                    int sid = sc.nextInt();
                    User foundById = sm.searchByUserId(sid);
                    if (foundById != null) {
                        System.out.println("Found: " + foundById.userId + ", " + foundById.name + ", " + foundById.age);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 8:
                    sm.countFriends();
                    break;
                case 9:
                    sm.displayAllUsers();
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
