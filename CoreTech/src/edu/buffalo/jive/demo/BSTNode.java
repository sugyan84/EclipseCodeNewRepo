package edu.buffalo.jive.demo;

public class BSTNode implements BST {

  private int data;
  private BSTNode left;
  private BSTNode right;

  public BSTNode(int data) {

    this.data = data;
    this.left = null;
    this.right = null;
  }

  @Override
  public int data() {

    return data;
  }

  @Override
  public void insert(int element) throws BSTException {

    if (data() >= element) {
      if (left() == null) {
        left = new BSTNode(element);
      }
      else {
        left().insert(element);
      }
    }
    else if (data() < element) {
      if (right() == null) {
        right = new BSTNode(element);
      }
      else {
        right().insert(element);
      }
    }
    else {
      throw new DuplicateElementException();
    }
  }

  @Override
  public BSTNode left() {

    return left;
  }

  @Override
  public BSTNode right() {

    return right;
  }
}