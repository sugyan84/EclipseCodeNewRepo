package edu.buffalo.jive.demo;

public interface BST {

  public int data();

  public void insert(int element) throws BSTException;

  public BST left();

  public BST right();

  public class BSTException extends Exception {

    private static final long serialVersionUID = 3515482520816813634L;
  }

  public class DuplicateElementException extends BSTException {

    private static final long serialVersionUID = 3376450932219031312L;
  }
}