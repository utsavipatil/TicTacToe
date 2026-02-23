package com.utsavi.tictactoe.stratergies;

import com.utsavi.tictactoe.Board;
import com.utsavi.tictactoe.Move;

public interface WinningStratergy {
  boolean checkMove(Board board , Move move);
}
