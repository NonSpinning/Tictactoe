package cell;
public class XCell implements CellState{
    private Cell cell;

    public XCell(Cell cell){this.cell = cell;}

    public String filledWith(){return "X";}
    public void fillX(){throw new IllegalStateException("There's already an X there");}
    public void fillO(){throw new IllegalStateException("There's an X there, you can't change it");}
}
