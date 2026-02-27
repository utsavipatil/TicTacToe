package com.utsavi.tictactoe;

import com.utsavi.tictactoe.stratergies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
  private Board board;
  private List<Player> players;
  private GameState gameState;
  private Player winner;
  private int nextPlayerIndex;
  private List<WinningStrategy> winningStratergies;
  private List<Move> moves;

  public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
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

  public void makeMove(){
    // Input from player
    Player currentPlayer = players.get(nextPlayerIndex);
    Move move = currentPlayer.makeMove(board);

    // Validate input
    try{
      validateMove(move);
    }catch (Exception exception){
      System.out.println(exception.getMessage() + " Please try again !!!");
      return;
    }

    //Update state of game
    updateGame(move, currentPlayer);

    //Check winner
    if(checkWinner(move)){
      winner = move.getPlayer();
      setGameState(GameState.SUCCESS);
    }else if(checkDraw()){
      setGameState(GameState.DRAW);
    }
  }

  public void updateGame(Move move, Player currentPlayer){
    int row = move.getCell().getRow(), col = move.getCell().getColumn();
    Cell currentCell = getBoard().getCell(row , col);
    currentCell.setCellState(CellState.FILLED);
    currentCell.setPlayer(currentPlayer);

    nextPlayerIndex++;
    nextPlayerIndex %= getPlayers().size(); //To rotate circularly

    move.setCell(currentCell);

    //Add to list of moves
    moves.add(move);
  }

  public boolean checkWinner(Move move){
    for(WinningStrategy strategy : winningStratergies){
      if(strategy.checkWinner(getBoard(), move)){
        return true;
      }
    }
    return false;
  }

  public boolean checkDraw(){
    return board.getSize() * board.getSize() == moves.size();
  }

  public void validateMove(Move move){
    //Validate cell
    int row = move.getCell().getRow(), col = move.getCell().getColumn();

    if(row < 0 || row >= getBoard().getSize() || col < 0 || col >= getBoard().getSize()){
      throw new RuntimeException("Invalid move :(");
    }

    //Validate CellState
    CellState cellState = getBoard().getCell(row, col).getCellState();
    if(cellState.equals(CellState.FILLED)){
      throw new RuntimeException("Invalid move !!! Cell is already filled :(");
    }
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

  public List<WinningStrategy> getWinningStratergies() {
    return winningStratergies;
  }

  public void setWinningStratergies(List<WinningStrategy> winningStratergies) {
    this.winningStratergies = winningStratergies;
  }

  public List<Move> getMoves() {
    return moves;
  }

  public void setMoves(List<Move> moves) {
    this.moves = moves;
  }
}
