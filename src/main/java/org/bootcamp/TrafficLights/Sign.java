package org.bootcamp.TrafficLights;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

/** Sign */
public class Sign extends JFrame {
  Light TestLight;

  Sign() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new GridLayout(4, 1));
    this.setPreferredSize(new Dimension(600, 600));
    this.setSize(600, 600);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.getContentPane().setBackground(Color.BLACK);
  }
}
