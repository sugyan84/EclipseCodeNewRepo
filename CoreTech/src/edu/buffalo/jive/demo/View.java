package edu.buffalo.jive.demo;

import javax.swing.SwingUtilities;

public class View {

  private TreeGUI gui;
  private Controller controller;
  private static final long ANIMATION_INTERVAL = 500;

  public View(Controller controller) {

    this.controller = controller;
  }

  public void show() {

    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {

        gui = new TreeGUI(controller);
        gui.pack();
        gui.setVisible(true);
      }
    });
  }

  public void updateUI() {

    gui.update(controller.getModel().getTree());
    try {
      Thread.sleep(ANIMATION_INTERVAL);
    }
    catch (InterruptedException ie) {
      ie.printStackTrace();
    }
  }
}