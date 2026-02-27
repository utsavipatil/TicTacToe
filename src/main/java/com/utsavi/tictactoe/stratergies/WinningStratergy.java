package com.utsavi.tictactoe.stratergies;

import com.utsavi.tictactoe.Board;
import com.utsavi.tictactoe.Move;

public interface WinningStratergy {
  boolean checkWinner(Board board , Move move);
}
