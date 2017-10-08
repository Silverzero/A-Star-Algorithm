
public class Tablero {
	
	private Nodo Inicio;
	private Nodo Fin;
	private Nodo[][] Mapa;
	private int DIM;
	
	public Tablero(Nodo Inicio, Nodo Fin, int Dim)
	{
		this.DIM = Dim;
		this.Inicio = Inicio;
		this.Fin = Fin;
		this.Mapa = new Nodo[Dim][Dim];	
		for(int i = 0; i < Dim; i++)
		{
			for(int j = 0; j < Dim; j++)
			{
				this.Mapa[i][j] = new Nodo(i,j);
			}
		}
	}

	public Nodo getInicio() {
		return this.Inicio;
	}

	public Nodo getFin() {
		return this.Fin;
	}
	
	public int getDim()
	{
		return this.DIM;
	}
	
	public void setCasilla(Nodo n){
		this.Mapa[n.getX()][n.getY()] = n;
	}
	
	public Nodo getNodo(int i, int j){
		
		if(i >= 0 && i < this.DIM && j >=0 && j<this.DIM)
		return this.Mapa[i][j];
		else return null;
	}
	
	public void setObstaculo(int x, int y)
	{
		this.Mapa[x][y].setPonible();		
	}
}
