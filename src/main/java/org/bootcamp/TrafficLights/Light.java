/** light */
package org.bootcamp.TrafficLights;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Light extends JPanel implements Runnable {

  int radius;
  int top;
  int bottom;
  int timeout;
  int length = 100;
  Color color;

  Light() {
    // this.setPreferredSize(new Dimension(250, 250));
    this.setPreferredSize(new Dimension(length, length));
    top = (length - radius) / 2;
    bottom = (length - radius) / 2;
    radius = length / 2;
    setVisible(true);
    timeout = 5;
  }

  Light(int timeout, Color color) {
    this();
    this.timeout = timeout;
    this.color = color;
    // this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
    setVisible(false);
    setBackground(Color.BLACK);
  }

  public void run() {
    setVisible(true);

    try {
      TimeUnit.SECONDS.sleep(timeout - 2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    flicker();
  }

  public void flicker() {
    for (int i = 0; i < 5; i++) {

      try {
        setVisible(false);
        TimeUnit.MILLISECONDS.sleep(250);
        setVisible(true);
        TimeUnit.MILLISECONDS.sleep(250);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    setVisible(false);
  }

  @Override
  public void paint(Graphics g) {
    // GOTTA DO THIS
    super.paint(g);
    setOpaque(true);
    setBorder(BorderFactory.createLineBorder(Color.WHITE));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2D = (Graphics2D) g;
    g2D.setPaint(color);
    g2D.setStroke(new BasicStroke(5));
    g2D.fillOval(top, bottom, radius, radius);
  }
}
