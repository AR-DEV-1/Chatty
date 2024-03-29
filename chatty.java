import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChattyApp {

    static Map<String, String> userData = new HashMap<>();
    static Map<String, String> chatData = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        String currentUsername = "";

        while (true) {
            if (!isLoggedIn) {
                System.out.println("Welcome to Chatty! Please choose an option:");
                System.out.println("1. Log in");
                System.out.println("2. Register");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("Enter your username:");
                        String username = scanner.nextLine();
                        System.out.println("Enter your password:");
                        String password = scanner.nextLine();

                        if (userData.containsKey(username) && userData.get(username).equals(password)) {
                            isLoggedIn = true;
                            currentUsername = username;
                            System.out.println("Successfully logged in!");
                        } else {
                            System.out.println("Invalid username or password!");
                        }

                        break;
                    case 2:
                        System.out.println("Enter your username:");
                        String newUsername = scanner.nextLine();
                        System.out.println("Enter your password:");
                        String newPassword = scanner.nextLine();

                        userData.put(newUsername, newPassword);

                        System.out.println("Account created successfully!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } else {
                System.out.println("Welcome back, " + currentUsername + "! Please choose an option:");
                System.out.println("1. Chat with a team");
                System.out.println("2. Chat with a friend");
                System.out.println("3. Video call");
                System.out.println("4. Log out");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("Enter team name:");
                        String teamName = scanner.nextLine();

                        if (!chatData.containsKey(teamName)) {
                            chatData.put(teamName, "");
                        }

                        System.out.println("Enter message (type /exit to quit):");

                        while (true) {
                            String message = scanner.nextLine();

                            if (message.equals("/exit")) {
                                break;
                            }

                            String currentChat = chatData.get(teamName);
                            chatData.put(teamName, currentChat + "[" + currentUsername + "] " + message + "\n");
                            System.out.println("Message sent!");
                        }

                        break;
                    case 2:
                        System.out.println("Enter friend's username:");
                        String friendName = scanner.nextLine();

                        if (!chatData.containsKey(friendName)) {
                            chatData.put(friendName, "");
                        }

                        System.out.println("Enter message (type /exit to quit):");

                        while (true) {
                            String message = scanner.nextLine();

                            if (message.equals("/exit")) {
                                break;
                            }

                            String currentChat = chatData.get(friendName);
                            chatData.put(friendName, currentChat + "[" + currentUsername + "] " + message + "\n");
                            System.out.println("Message sent!");
                        }

                        break;
                    case 3:
                        System.out.println("Video call feature is not available yet!");
                        break;
                    case 4:
                        isLoggedIn = false;
                        currentUsername = "";
                        System.out.println("Successfully logged out!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        }
    }
}
