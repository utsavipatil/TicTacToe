package com.utsavi.tictactoe;

public class Cell {
  private int row;
  private int column;
  private CellState cellState ;
  Player player;

  public void display(){
    if(cellState.equals(CellState.FILLED)){
      System.out.print("[" + player.getSymbol().getSymbol() + "] ");
    }else{
      System.out.print("[ ] ");
    }
  }

  public Cell(int row, int col){
    this.row = row;
    this.column = col;
    this.cellState = CellState.EMPTY;
    this.player = null;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  public CellState getCellState() {
    return cellState;
  }

  public void setCellState(CellState cellState) {
    this.cellState = cellState;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }
}
