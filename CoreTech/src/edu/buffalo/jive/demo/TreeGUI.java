package edu.buffalo.jive.demo;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TreeGUI extends JFrame {

  private static final long serialVersionUID = 435602610901916317L;

  private JPanel pnTop;
  private TreePanel pnTree;
  private JTextField edFileName;
  private JButton btnLoad;
  private JFileChooser fc;
  private Controller controller;

  public TreeGUI(Controller controller) {

    this.controller = controller;
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    edFileName = new JTextField(40);
    edFileName.setEditable(false);

    btnLoad = new JButton("Load...");
    btnLoad.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        edFileName.setText("");
        pnTree.clear();
        if (fc == null) {
          fc = new JFileChooser();
        }
        if (fc.showOpenDialog(TreeGUI.this) == JFileChooser.APPROVE_OPTION) {
          edFileName.setText(fc.getSelectedFile().getPath());
          getController().loadModel(fc.getSelectedFile());
        }
      }
    });

    JPanel input1 = new JPanel();
    input1.add(new JLabel("Tree file:"));
    input1.add(edFileName);
    input1.add(btnLoad);

    pnTop = new JPanel();
    pnTop.setLayout(new BorderLayout());
    pnTop.add("North", input1);

    pnTree = new TreePanel();
    pnTree.setOpaque(true);
    pnTree.setBackground(Color.WHITE);
    pnTree.addComponentListener(new ComponentAdapter() {

      @Override
      public void componentResized(ComponentEvent e) {

        getController().updateView();
      }
    });

    setLayout(new BorderLayout());
    add("North", pnTop);
    add("Center", pnTree);
    setPreferredSize(new Dimension(640, 400));
  }

  private Controller getController() {

    return controller;
  }

  public void update(BST tree) {

    pnTree.drawTree(tree);
  }
}