package cell;
public class Cell{
    private XCell xCell = new XCell(this);
    private OCell oCell = new OCell(this);
    private EmptyCell emptyCell = new EmptyCell(this);
    private CellState currentState = emptyCell;

    public String filledWith(){return currentState.filledWith();}
    public void fillX(){currentState.fillX();}
    public void fillO(){currentState.fillO();}

    public XCell getXCell(){return this.xCell;}
    public OCell getOCell(){return this.oCell;}
    public EmptyCell getEmptyCell(){return this.emptyCell;}
    public CellState getCurrentState(){return this.currentState;}
    public void setCurrentState(CellState nuevo){this.currentState = nuevo;}
}
