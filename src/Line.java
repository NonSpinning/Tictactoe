import cell.*;
public class Line{
    private Cell[] cells= new Cell[3];

    public Line(Cell cell1, Cell cell2, Cell cell3){
	cells[0] = cell1;
	cells[1] = cell2;
	cells[2] = cell3;
    }

    public String isFull(){
	int Xcount = 0;
	int Ocount = 0;
	for(int i=0; i<3; ++i){
	    if(cells[i].getCurrentState() == cells[i].getXCell())++Xcount;
	    if(cells[i].getCurrentState() == cells[i].getOCell())++Ocount;
	}
	if (Xcount == 3) return "X";
	if (Ocount == 3) return "O";
	return null;
    }

    public boolean missing(String symbol){
	int forcount =0;
	int againstcount =0;
	switch(symbol){
	case "X":
	    for (int i =0;i<3;++i){
		if(cells[i].filledWith().equals("X")) ++forcount;
		if(cells[i].filledWith().equals("O")) ++againstcount;
	    }
	    if(forcount ==2 && againstcount == 0) return true;
	    return false;
	case "O":
	    for (int i =0;i<3;++i){
		if(cells[i].filledWith().equals("O")) ++forcount;
		if(cells[i].filledWith().equals("X")) ++againstcount;
	    }
	    if(forcount ==2 && againstcount == 0) return true;
	    return false;
	default:
	    throw new IllegalArgumentException();
	}
    }

    public Cell getMissing(){
	for(int i=0; i<3;++i){
	    if(cells[i].filledWith().equals(" ")) return cells[i];
	}
	return null;
    }

      public boolean isFree(String symbol){
	int forcount =0;
	int againstcount =0;
	switch(symbol){
	case "X":
	    for (int i =0;i<3;++i){
		if(cells[i].filledWith().equals("X")) ++forcount;
		if(cells[i].filledWith().equals("O")) ++againstcount;
	    }
	    if(forcount ==1 && againstcount == 0) return true;
	    return false;
	case "O":
	    for (int i =0;i<3;++i){
		if(cells[i].filledWith().equals("O")) ++forcount;
		if(cells[i].filledWith().equals("X")) ++againstcount;
	    }
	    if(forcount ==1 && againstcount == 0) return true;
	    return false;
	default:
	    throw new IllegalArgumentException();
	}
    }
 
}
