package com.utsavi.tictactoe;

import com.utsavi.tictactoe.stratergies.WinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class Game {
  private Board board;
  private List<Player> players;
  private GameState gameState;
  private Player winner;
  private int nextPlayerIndex;
  private List<WinningStratergy> winningStratergies;
  private List<Move> moves;

  public Game(int dimension, List<Player> players, List<WinningStratergy> winningStrategies){
    this.board = new Board(dimension);
    this.players = players;
    this.gameState = GameState.IN_PROGRESS;
    this.winner = null;
    this.nextPlayerIndex = 0;
    this.winningStratergies = winningStrategies;
    this.moves = new ArrayList<>();
  }

  public void display(){
    board.display();
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public GameState getGameState() {
    return gameState;
  }

  public void setGameState(GameState gameState) {
    this.gameState = gameState;
  }

  public Player getWinner() {
    return winner;
  }

  public void setWinner(Player winner) {
    this.winner = winner;
  }

  public int getNextPlayerIndex() {
    return nextPlayerIndex;
  }

  public void setNextPlayerIndex(int nextPlayerIndex) {
    this.nextPlayerIndex = nextPlayerIndex;
  }

  public List<WinningStratergy> getWinningStratergies() {
    return winningStratergies;
  }

  public void setWinningStratergies(List<WinningStratergy> winningStratergies) {
    this.winningStratergies = winningStratergies;
  }

  public List<Move> getMoves() {
    return moves;
  }

  public void setMoves(List<Move> moves) {
    this.moves = moves;
  }
}
