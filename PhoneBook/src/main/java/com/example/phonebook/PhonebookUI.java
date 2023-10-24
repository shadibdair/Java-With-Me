package com.example.phonebook;

// Import required classes for JavaFX and file handling
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

// Class to represent the UI of the phonebook
public class PhonebookUI extends Application {

    private PhoneBook phoneBook;
    private ListView<String> listView;

    @Override
    public void start(Stage primaryStage) {
        phoneBook = new PhoneBook();

        // Setting up the UI components
        listView = new ListView<>();
        TextField nameField = new TextField();
        TextField phoneField = new TextField();
        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        Button saveButton = new Button("Save");
        Button loadButton = new Button("Load");

        // Event handlers for the buttons
        addButton.setOnAction(e -> {
            phoneBook.add(nameField.getText(), phoneField.getText());
            updateListView();
        });

        updateButton.setOnAction(e -> {
            phoneBook.update(nameField.getText(), phoneField.getText());
            updateListView();
        });

        deleteButton.setOnAction(e -> {
            phoneBook.delete(nameField.getText());
            updateListView();
        });

        saveButton.setOnAction(e -> savePhonebook());
        loadButton.setOnAction(e -> loadPhonebook());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(listView, nameField, phoneField, addButton, updateButton, deleteButton, saveButton, loadButton);

        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Phonebook");
        primaryStage.show();
    }

    // Method to update the ListView with the current phonebook entries
    private void updateListView() {
        listView.getItems().clear();
        for (Map.Entry<String, String> entry : phoneBook.getPhonebook().entrySet()) {
            listView.getItems().add(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to save the phonebook to a file
    private void savePhonebook() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("phonebook.dat"))) {
            out.writeObject(phoneBook.getPhonebook());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Method to load the phonebook from a file
    private void loadPhonebook() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("phonebook.dat"))) {
            phoneBook.getPhonebook().clear();
            phoneBook.getPhonebook().putAll((TreeMap<String, String>) in.readObject());
            updateListView();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {}}
