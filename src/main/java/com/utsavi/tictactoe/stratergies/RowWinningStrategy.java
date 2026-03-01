package com.utsavi.tictactoe.stratergies;

import com.utsavi.tictactoe.Board;
import com.utsavi.tictactoe.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy {

  private HashMap<Integer, HashMap<String, Integer>> rowCount = new HashMap<>();

  @Override
  public boolean checkWinner(Board board, Move move) {
    int row = move.getCell().getRow();
    String symbol = move.getPlayer().getSymbol().getSymbol();

    if(!rowCount.containsKey(row)){
      rowCount.put(row, new HashMap<>());
    }

    if(!rowCount.get(row).containsKey(symbol)){
      rowCount.get(row).put(symbol, 0);
    }
    //Increase Frequency
    rowCount.get(row).put(symbol, rowCount.get(row).get(symbol) + 1);

    return rowCount.get(row).get(symbol) == board.getSize() ;
  }

}
