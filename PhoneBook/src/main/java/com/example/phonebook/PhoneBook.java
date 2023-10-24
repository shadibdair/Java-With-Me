package com.example.phonebook;
// Import required classes
import java.util.TreeMap;
// Class that represents a phonebook
public class PhoneBook {

    // TreeMap to store names and their corresponding phone numbers in a sorted manner
    private TreeMap<String, String> phonebook;

    // Constructor to initialize the phonebook
    public PhoneBook() {
        phonebook = new TreeMap<>();
    }

    // Method to add a name and phone number
    public void add(String name, String phoneNumber) {
        phonebook.put(name, phoneNumber);
    }

    // Method to delete a name and its corresponding phone number
    public void delete(String name) {
        phonebook.remove(name);
    }

    // Method to update a phone number for a given name
    public void update(String name, String phoneNumber) {
        phonebook.put(name, phoneNumber); // Will overwrite the existing value
    }

    // Method to search for a phone number by name
    public String search(String name) {
        return phonebook.get(name);
    }

    // Method to get the entire phonebook
    public TreeMap<String, String> getPhonebook() {
        return phonebook;
    }
}
