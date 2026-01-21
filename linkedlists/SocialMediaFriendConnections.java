package linkedlists;

import java.util.ArrayList;

/**
 * SocialMediaFriendConnections - Manages friend connections using a Singly
 * Linked List.
 * Attributes: User ID, Name, Age, List of Friend IDs.
 * Implementation: Add/Remove Connections, Mutual Friends, Search, Friends
 * Count.
 */
public class SocialMediaFriendConnections {

    private static class Node {
        int userId, age;
        String name;
        // The list of friends can be another linked list or an array of Friend IDs
        ArrayList<Integer> friendIds;
        Node next;

        Node(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendIds = new ArrayList<>();
        }
    }

    private Node head;

    // Add a new user to the network
    public void addUser(int userId, String name, int age) {
        Node newNode = new Node(userId, name, age);
        newNode.next = head;
        head = newNode;
    }

    private Node findUser(int id) {
        Node current = head;
        while (current != null) {
            if (current.userId == id)
                return current;
            current = current.next;
        }
        return null;
    }

    // Add a reciprocal friend connection between two users
    public void addFriendConnection(int id1, int id2) {
        Node u1 = findUser(id1);
        Node u2 = findUser(id2);
        if (u1 != null && u2 != null) {
            if (!u1.friendIds.contains(id2))
                u1.friendIds.add(id2);
            if (!u2.friendIds.contains(id1))
                u2.friendIds.add(id1);
        }
    }

    // Remove a friend connection between two users
    public void removeFriendConnection(int id1, int id2) {
        Node u1 = findUser(id1);
        Node u2 = findUser(id2);
        if (u1 != null && u2 != null) {
            u1.friendIds.remove(Integer.valueOf(id2));
            u2.friendIds.remove(Integer.valueOf(id1));
        }
    }

    // Find and display mutual friends between two users
    public void findMutualFriends(int id1, int id2) {
        Node u1 = findUser(id1);
        Node u2 = findUser(id2);
        if (u1 == null || u2 == null)
            return;

        System.out.println("\nMutual Friends between " + u1.name + " and " + u2.name + ":");
        // Compare friend lists of both users
        for (int fid : u1.friendIds) {
            if (u2.friendIds.contains(fid)) {
                Node mutualFriend = findUser(fid);
                if (mutualFriend != null)
                    System.out.println("- " + mutualFriend.name);
            }
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        Node user = findUser(userId);
        if (user == null)
            return;
        System.out.print("\n" + user.name + "'s Friends: ");
        // Print names corresponding to Friend IDs
        for (int fid : user.friendIds) {
            Node fNode = findUser(fid);
            if (fNode != null)
                System.out.print(fNode.name + " ");
        }
        System.out.println();
    }

    // Count and display friends for each user
    public void displayFriendCounts() {
        Node current = head;
        while (current != null) {
            System.out.println("User: " + current.name + " | Friend Count: " + current.friendIds.size());
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaFriendConnections net = new SocialMediaFriendConnections();
        net.addUser(1, "Alice", 25);
        net.addUser(2, "Bob", 30);
        net.addUser(3, "Charlie", 22);
        net.addUser(4, "Diana", 28);

        net.addFriendConnection(1, 2); // Alice - Bob
        net.addFriendConnection(1, 4); // Alice - Diana
        net.addFriendConnection(2, 4); // Bob - Diana
        net.addFriendConnection(3, 1); // Charlie - Alice

        net.displayFriends(1);
        net.findMutualFriends(1, 2); // Should be Diana
        net.displayFriendCounts();
    }
}
