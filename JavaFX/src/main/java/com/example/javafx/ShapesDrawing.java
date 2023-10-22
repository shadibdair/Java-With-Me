package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

public class ShapesDrawing extends Application {

    // Canvas for drawing shapes
    private Canvas canvas;

    // Dimensions of the canvas
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {
        // Main layout container
        BorderPane root = new BorderPane();

        // Setting up the canvas
        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        root.setCenter(canvas);

        // Button to trigger drawing
        Button drawButton = new Button("Draw Shapes");
        drawButton.setOnAction(e -> drawShapes());
        root.setTop(drawButton);

        // Setting up the scene and stage
        Scene scene = new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Random Shapes Drawing");
        primaryStage.show();

        // Draw shapes when the application starts
        drawShapes();
    }

    // Function to draw random shapes
    private void drawShapes() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Clear previous drawings
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Random generator
        Random rand = new Random();

        // Drawing 10 random shapes
        for (int i = 0; i < 10; i++) {
            double x = rand.nextDouble() * CANVAS_WIDTH;
            double y = rand.nextDouble() * CANVAS_HEIGHT;
            double width = rand.nextDouble() * (CANVAS_WIDTH / 4);
            double height = rand.nextDouble() * (CANVAS_HEIGHT / 4);
            Color color = new Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), 1.0);

            // Decide the shape to draw: rectangle, ellipse, or line
            int shapeType = rand.nextInt(3);
            if (shapeType == 0) { // Rectangle
                gc.setFill(color);
                gc.fillRect(x, y, width, height);
            } else if (shapeType == 1) { // Ellipse
                gc.setFill(color);
                gc.fillOval(x, y, width, height);
            } else { // Line
                double endX = x + width;
                double endY = y + height;
                gc.setStroke(color);
                gc.strokeLine(x, y, endX, endY);
            }
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}
