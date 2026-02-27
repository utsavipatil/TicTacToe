package com.utsavi.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
  private List<List<Cell>> grid;
  private int size;

  public Board(int size){
    this.size = size;

    this.grid = new ArrayList<>();

    for(int r = 0; r < size; r++){
      List<Cell> row = new ArrayList<>();
      for(int c = 0; c < size; c++){
        Cell cell = new Cell(r , c);
        row.add(cell);
      }
      this.grid.add(row);
    }
  }

  public void display(){
    int row = grid.size(), col = grid.get(0).size();
    for(int i = 0; i < row ; i++){
      for(int j = 0; j < col; j++){
        grid.get(i).get(j).display();
      }
      System.out.println();
    }

    System.out.println();
  }

  public Cell getCell(int row, int col){
    return getGrid().get(row).get(col);
  }

  public List<List<Cell>> getGrid() {
    return grid;
  }

  public void setGrid(List<List<Cell>> grid) {
    this.grid = grid;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
