package com.utsavi.tictactoe;

public class Bot extends Player{

  private BotDifficultyLevel botDifficultyLevel;

  public Bot(Integer id, String name , PlayerType playerType , Symbol symbol, BotDifficultyLevel botDifficultyLevel){
    super(id, name , playerType , symbol);
    this.botDifficultyLevel = botDifficultyLevel;
  }

  @Override
  public Move makeMove(){
    System.out.println("Hey ! " + getName() + " Its your turn. Please make move.");
    return null;
  }
}
