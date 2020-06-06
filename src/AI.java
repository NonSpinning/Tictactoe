import cell.*;
import java.util.ArrayList;
public class AI{
    private String symbol;
    private Tictactoe ttt;

    public AI(String symbol, Tictactoe ttt){
	if (!(symbol.equals("X") || symbol.equals("O"))) throw new IllegalArgumentException();
	this.symbol = symbol;
	this.ttt = ttt;
    }

    public void playTurn(){
	ArrayList<Line> lineas = ttt.getLines();
	Cell[] board = ttt.getBoard();
	String enemySymbol = symbol.equals("X")? "O": "X";
        for(Line x:lineas){
	    if(x.missing(symbol)){
		Cell tofill =(x.getMissing());
		if(symbol.equals("X")) tofill.fillX();
		else tofill.fillO();
		return;
	    }
	}
	for(Line x:lineas){
	    if(x.missing(enemySymbol)){
		Cell tofill =(x.getMissing());
		if(symbol.equals("X")) tofill.fillX();
		else tofill.fillO();
		return;
	    }
	}
	Cell tofill = null;
	if(board[1].filledWith().equals(enemySymbol) && board[3].filledWith().equals(enemySymbol) && board[0].filledWith().equals(" "))tofill = board[0];
	if(board[1].filledWith().equals(enemySymbol) && board[5].filledWith().equals(enemySymbol) && board[2].filledWith().equals(" "))tofill = board[2];
	if(board[7].filledWith().equals(enemySymbol) && board[5].filledWith().equals(enemySymbol) && board[8].filledWith().equals(" "))tofill = board[8];
	if(board[7].filledWith().equals(enemySymbol) && board[3].filledWith().equals(enemySymbol) && board[6].filledWith().equals(" "))tofill = board[6];
	if(tofill != null){
	    if(symbol.equals("X")) tofill.fillX();
		else tofill.fillO();
		return;
	}
	for(Line x:lineas){
	    if(x.isFree(symbol)){
		tofill =(x.getMissing());
		if(symbol.equals("X")) tofill.fillX();
		else tofill.fillO();
		return;
	    }
	}
	if(board[4].filledWith().equals(" ")){
	    tofill=board[4];
	    if(symbol.equals("X")) tofill.fillX();
	    else tofill.fillO();
	    return;
	}
	for(int i = 0; i<9; ++i){
	    if(board[i].filledWith().equals(" ")){
		tofill = board[i];
		if(symbol.equals("X")) tofill.fillX();
		else tofill.fillO();
		return;
	    }
	}
    }
    
}
