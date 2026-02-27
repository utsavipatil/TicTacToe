package com.utsavi.tictactoe.stratergies;

import com.utsavi.tictactoe.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
  //EASY: Bot makes move to next empty cell
  @Override
  public Move makeMove(Board board, Player player) {
    for(List<Cell> raw: board.getGrid()){
      for(Cell cell : raw){
        if(cell.getCellState().equals(CellState.EMPTY)){
          return new Move(new Cell(cell.getRow(), cell.getColumn()), player);
        }
      }
    }
    return null;
  }
}
