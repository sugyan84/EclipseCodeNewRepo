package edu.buffalo.jive.demo;

import edu.buffalo.jive.demo.BST.BSTException;

public class Model {

  private BST tree;

  public void clear() {

    tree = null;
  }

  public BST getTree() {

    return tree;
  }

  public void insertNode(int element) throws BSTException {

    if (tree == null) {
      tree = new BSTNode(element);
    }
    else {
      tree.insert(element);
    }
  }
}