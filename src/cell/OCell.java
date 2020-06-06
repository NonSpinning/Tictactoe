package cell;
public class OCell implements CellState{
    private Cell cell;

    public OCell(Cell cell){this.cell = cell;}

    public String filledWith(){return "O";}
    public void fillX(){throw new IllegalStateException("There's an O there, you can't change it");}
    public void fillO(){throw new IllegalStateException("There's already an O there");}
}
