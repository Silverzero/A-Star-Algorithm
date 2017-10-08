public class Nodo implements Comparable<Nodo> {

	private int x;
	private int y;
	private Nodo padre;
	private boolean ponible;
	private double heuristica = 0f;
	
	public Nodo(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.padre = null;
		this.ponible = true;
	}
	
	public Nodo(int x, int y, Nodo p)
	{
		this.x = x;
		this.y = y;
		this.padre = p;
		this.ponible = true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Nodo getPadre() {
		return padre;
	}
	
	public void setPadre(Nodo n){
		this.padre = n;
	}
	
	public boolean getPonible(){
		return this.ponible;
	}
	
	public void setPonible() {
		this.ponible = false;
	}
	
	public void setHeuristica(double d)
	{
		this.heuristica = d;
	}
	
	public double calcularHeuristica(Nodo inicio, Nodo fin)
	{
		return calcularH(fin)+calcularG(inicio); 	
	}

	private double calcularG(Nodo inicio) {
	
		return Math.sqrt(Math.pow((this.x - inicio.getX()), 2) + Math.pow((this.y - inicio.getY()), 2));
	}

	private double calcularH(Nodo fin) {
		
		return Math.sqrt(Math.pow((this.x - fin.getX()), 2) + Math.pow((this.y - fin.getY()), 2)); 
	}
	
	public String toString()
	{
		return "(" + this.x + "," + this.y + ")";
	}


	@Override
	public int compareTo(Nodo nodo) {
		 if (this.heuristica < nodo.heuristica)
		 {
             return -1;
         }
         if (this.heuristica > nodo.heuristica) 
         {
             return 1;
         }
         return 0;
	}
}
