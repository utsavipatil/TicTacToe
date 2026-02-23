package com.utsavi.tictactoe;

import com.utsavi.tictactoe.stratergies.WinningStratergy;

import java.util.List;

public class Game {
  private Board board;
  private List<Player> players;
  private GameState gameState;
  private Player winner;
  private int nextPlayerIndex;
  private List<WinningStratergy> winningStratergies;
  private List<Move> moves;
}
