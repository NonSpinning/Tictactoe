package cell;
public class EmptyCell implements CellState{
    private Cell cell;

    public EmptyCell(Cell cell){this.cell = cell;}

    public String filledWith(){return " ";}
    public void fillX(){cell.setCurrentState(cell.getXCell());}
    public void fillO(){cell.setCurrentState(cell.getOCell());}
}
