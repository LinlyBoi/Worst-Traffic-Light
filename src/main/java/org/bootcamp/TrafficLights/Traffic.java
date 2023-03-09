package org.bootcamp.TrafficLights;

import javax.swing.JButton;

public class Traffic {

  public static boolean pressed = false;

  public static void main(String[] args) {
    // Countdowns
    // Lights
    Redlight redlight = new Redlight();
    Yellowlight yellowlight = new Yellowlight();
    Greenlight greenlight = new Greenlight();

    // Container for the lights and button to stop
    Sign Traffic_Sign = new Sign();
    Traffic_Sign.add(redlight, 0);
    Traffic_Sign.add(yellowlight, 1);
    Traffic_Sign.add(greenlight, 2);

    // Threads
    // Thread red_thread = new Thread(redlight);
    // Thread yellow_thread = new Thread(yellowlight);
    // Thread green_thread = new Thread(greenlight);
    // Button
    JButton StopButton = new JButton("STOP");
    StopButton.addActionListener(
        e -> {
          pressed = true;
        });
    Traffic_Sign.add(StopButton, 3);

    while (true) {
      Thread red_thread = new Thread(redlight);
      Thread yellow_thread = new Thread(yellowlight);
      Thread green_thread = new Thread(greenlight);
      red_thread.start();
      try {
        red_thread.join();
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
      if (pressed)
        break;
      yellow_thread.start();
      try {
        yellow_thread.join();
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
      if (pressed)
        break;
      green_thread.start();
      try {
        green_thread.join();
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
      if (pressed)
        break;
    }
  }
}
