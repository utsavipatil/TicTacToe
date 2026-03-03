package com.utsavi.tictactoe.stratergies;

import com.utsavi.tictactoe.Board;
import com.utsavi.tictactoe.Move;

public class ColumnWinningStratergy implements WinningStrategy {

  @Override
  public boolean checkWinner(Board board, Move move) {
    return false;
  }

  @Override
  public boolean handleUndo(Board board, Move move) {
    return false;
  }
}
