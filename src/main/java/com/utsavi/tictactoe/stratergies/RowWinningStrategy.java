package com.utsavi.tictactoe.stratergies;

import com.utsavi.tictactoe.Board;
import com.utsavi.tictactoe.Move;

public class RowWinningStrategy implements WinningStrategy {

  @Override
  public boolean checkWinner(Board board, Move move) {
    return false;
  }
}
