package com.utsavi.tictactoe;

import java.util.Scanner;

public class Human extends Player{

  private int level;
  private int coins;
  private static Scanner scanner = new Scanner(System.in);

  public Human(Integer id, String name , PlayerType playerType, Symbol symbol){
    super(id, name , playerType, symbol);
    level = 1;
    coins = 50;
  }

  @Override
  public Move makeMove(Board board){
    System.out.println("Hey ! " + getName() + " Its your turn. Please make move.");
    System.out.println("Please enter ROW in which you want to make move:");
    int row = scanner.nextInt();
    System.out.println("Please enter COLUMN in which you want to make move:");
    int col = scanner.nextInt();

    return new Move(new Cell(row, col) , this);
  }
}
