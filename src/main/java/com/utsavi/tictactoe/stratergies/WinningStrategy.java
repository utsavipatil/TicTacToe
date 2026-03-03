package com.utsavi.tictactoe.stratergies;

import com.utsavi.tictactoe.Board;
import com.utsavi.tictactoe.Move;

public interface WinningStrategy {
  boolean checkWinner(Board board , Move move);

  boolean handleUndo(Board board, Move move);
}
