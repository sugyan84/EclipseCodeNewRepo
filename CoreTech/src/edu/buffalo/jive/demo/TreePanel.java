package edu.buffalo.jive.demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class TreePanel extends JComponent {

  private static final long serialVersionUID = 1667058772086193507L;

  private Image image;  
  private int imageWidth, imageHeight;
  
  public void clear() {

    newImage();
    getGraphics().drawImage(getImage(), 0, 0, this);
  }

  
  protected void drawNode(Graphics g, int subtreeWidth, BST tree, int x, int y) {

    int gutter = 3;
    int deltaY = 40;
    String text = Integer.toString(tree.data());
    RenderingHints renderHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    renderHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHints(renderHints);
    g2d.setColor(Color.GRAY);
    g2d.setStroke(new BasicStroke(1));
    FontMetrics fm = g2d.getFontMetrics();
    int sw = fm.stringWidth(text);
    int sh = fm.getHeight();
    g2d.fill(new Rectangle2D.Double(x - gutter - sw / 2, y, 2 * gutter + sw, 2 * gutter + sh));
    g2d.setColor(Color.BLACK);
    g2d.drawString(text, x - sw / 2, y + gutter + sh - fm.getDescent());

    if (tree.left() != null) {
      g2d.drawLine(x - gutter - sw / 2, y + 2 * gutter + sh, x - subtreeWidth / 2, y + deltaY);
      drawNode(g, subtreeWidth / 2, tree.left(), x - subtreeWidth / 2, y + deltaY);
    }

    if (tree.right() != null) {
      g2d.drawLine(x + gutter + sw / 2, y + 2 * gutter + sh, x + subtreeWidth / 2, y + deltaY);
      drawNode(g, subtreeWidth / 2, tree.right(), x + subtreeWidth / 2, y + deltaY);
    }
  }

  
  public void drawTree(BST tree) {

    Dimension d = getBounds().getSize();
    if (getImage() == null || getImageWidth() != d.width || getImageHeight() != d.height) {
      newImage();
    }
    if (tree != null) {
      drawNode(getImage().getGraphics(), getImageWidth() / 2, tree, getImageWidth() / 2, 10);
    }
    getGraphics().drawImage(getImage(), 0, 0, this);
  }

  
  protected Image getImage() {
  
    return image;
  }

  
  protected int getImageHeight() {
  
    return imageHeight;
  }

  protected int getImageWidth() {
  
    return imageWidth;
  }

  protected void newImage() {

    Dimension d = getBounds().getSize();
    image = createImage(d.width, d.height);
    imageWidth = d.width;
    imageHeight = d.width;
    Graphics gr = image.getGraphics();
    gr.setColor(getBackground());
    gr.fillRect(0, 0, imageWidth, imageHeight);
  }

  @Override
  public void paint(Graphics g) {

    if (image == null) {
      newImage();
    }
    g.drawImage(image, 0, 0, this);
  }
}