package edu.buffalo.jive.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Controller {

  private Model model;
  private View view;

  public Controller() {

    model = new Model();
    view = new View(this);
  }

  public Model getModel() {

    return model;
  }

  public void loadModel(File file) {

    getModel().clear();
    try {
      BufferedReader in = new BufferedReader(new FileReader(file));
      String line;
      while ((line = in.readLine()) != null) {
        try {
          model.insertNode(Integer.parseInt(line));
          view.updateUI();
        }
        catch (NumberFormatException nfe) {
          nfe.printStackTrace();
        }
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void showView() {

    view.show();
  }

  public void updateView() {

    view.updateUI();
  }
}