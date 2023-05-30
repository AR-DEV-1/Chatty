function myFunction() {
const userData = new Map();
const chatData = new Map();
const scanner = require('readline-sync');
let isLoggedIn = false;
let currentUsername = "";
while (true) {
    if (!isLoggedIn) {
        console.log("Welcome to Chatty! Please choose an option:");
        console.log("1. Log in");
        console.log("2. Register");
        let choice = scanner.questionInt();
        switch (choice) {
            case 1:
                console.log("Enter your username:");
                let username = scanner.question();
                console.log("Enter your password:");
                let password = scanner.question();
                if (userData.has(username) && userData.get(username) === password) {
                    isLoggedIn = true;
                    currentUsername = username;
                    console.log("Successfully logged in!");
                } else {
                    console.log("Invalid username or password!");
                }
                break;
            case 2:
                console.log("Enter your desired username:");
                let newUsername = scanner.question();
                console.log("Enter your desired password:");
                let newPassword = scanner.question();
                if (userData.has(newUsername)) {
                    console.log("Username already taken!");
                } else {
                    userData.set(newUsername, newPassword);
                    console.log("Successfully registered!");
                }
                break;
            default:
                console.log("Invalid choice!");
                break;
        }
    } else {
        console.log("Welcome back, " + currentUsername + "!");
        console.log("What would you like to do?");
        console.log("1. View chat history");
        console.log("2. Send a message");
        console.log("3. Log out");
        let choice = scanner.questionInt();
        switch (choice) {
            case 1:
                console.log("Chat history:");
                if (chatData.has(currentUsername)) {
                    console.log(chatData.get(currentUsername));
                } else {
                    console.log("No chat history found.");
                }
                break;
            case 2:
                console.log("Enter recipient:");
                let recipient = scanner.question();
                console.log("Enter message:");
                let message = scanner.question();
                if (chatData.has(recipient)) {
                    chatData.set(recipient, chatData.get(recipient) + "\n" + currentUsername + ": " + message);
                } else {
                    chatData.set(recipient, currentUsername + ": " + message);
                }
                console.log("Message sent!");
                break;
            case 3:
                isLoggedIn = false;
                currentUsername = "";
                console.log("Successfully logged out!");
                break;
            default:
                console.log("Invalid choice!");
                break;
        }
     }
  }
