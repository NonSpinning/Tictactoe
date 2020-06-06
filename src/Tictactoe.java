import cell.Cell;
import java.util.Scanner;
import java.util.ArrayList;
public class Tictactoe{
    private Cell[] tablero = new Cell[9];
    private ArrayList<Line> lineas;

    public static void main(String[] args){
	System.out.println("¿AI?");
	Scanner scanner = new Scanner(System.in);
	String s = scanner.nextLine();
	System.out.println("0|1|2\n-+-+-\n3|4|5\n-+-+-\n6|7|8\nPara ocupar una celda, elige el número correspondiente.");
	Tictactoe tic = new Tictactoe();
	if (s.equals("N")){
		for (int i=1; i<10; ++i){
		    if(i%2==1)
			{
			    System.out.println("Toca X, escribe donde quieres ponerla:");
			    tic.tablero[scanner.nextInt()].fillX();
			}else{
			    System.out.println("Toca O, escribe donde quieres ponerla:");
			    tic.tablero[scanner.nextInt()].fillO();
		    }
		    tic.drawBoard();
		    for (Line x: tic.lineas){
			if(x.isFull() == null) continue;
			if(x.isFull().equals("X")){
			    System.out.println("Gana X");
			    System.exit(0);
			}
			if(x.isFull().equals("O")){
			    System.out.println("Gana O");
			    System.exit(0);
			}
		    }
		}
		System.out.println("Empate");
		System.exit(0);
	    }
	    else{
		AI ai= new AI("O", tic);
		for (int i=1; i<10; ++i){
		    if(i%2==1)
			{
			    System.out.println("Toca X, escribe donde quieres ponerla:");
			    tic.tablero[scanner.nextInt()].fillX();
			}else{
			System.out.println("La computadora jugo:");
			ai.playTurn();
		    }
		    tic.drawBoard();
		    for (Line x: tic.lineas){
			if(x.isFull() == null) continue;
			if(x.isFull().equals("X")){
			    System.out.println("Gana X");
			    System.exit(0);
			}
			if(x.isFull().equals("O")){
			    System.out.println("Gana O");
			    System.exit(0);
			}
		    }
		}
		System.out.println("Empate");
		System.exit(0);
	    }
    }

    public Tictactoe(){
	for(int i=0; i<9; ++i){
	    tablero[i] = new Cell();
	}
	lineas = this.generateLines();
    }

    public void drawBoard(){
	System.out.println(tablero[0].filledWith()+"|"+tablero[1].filledWith()+"|"+tablero[2].filledWith());
	System.out.println("-+-+-");
	System.out.println(tablero[3].filledWith()+"|"+tablero[4].filledWith()+"|"+tablero[5].filledWith());
	System.out.println("-+-+-");
	System.out.println(tablero[6].filledWith()+"|"+tablero[7].filledWith()+"|"+tablero[8].filledWith());
    }

    public ArrayList<Line> generateLines(){
	ArrayList<Line> lineas = new ArrayList<Line>();
	lineas.add(new Line(tablero[0],tablero[1],tablero[2]));
	lineas.add(new Line(tablero[3],tablero[4],tablero[5]));
	lineas.add(new Line(tablero[6],tablero[7],tablero[8]));
	lineas.add(new Line(tablero[0],tablero[3],tablero[6]));
	lineas.add(new Line(tablero[1],tablero[4],tablero[7]));
	lineas.add(new Line(tablero[2],tablero[5],tablero[8]));
	lineas.add(new Line(tablero[0],tablero[4],tablero[8]));
	lineas.add(new Line(tablero[6],tablero[4],tablero[2]));
	return lineas;
    }

    public ArrayList<Line> getLines(){
	return this.lineas;
    }

    public Cell[] getBoard(){
	return tablero;
    }
 
}
