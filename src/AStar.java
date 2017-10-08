import java.util.ArrayList;
import java.util.Collections;


public class AStar {
	
	private Tablero tablero;
	private ArrayList<Nodo> ListaAbierta = new ArrayList<Nodo>();
	private ArrayList<Nodo> ListaCerrada = new ArrayList<Nodo>();
	private ArrayList<Nodo> Solucion = new ArrayList<Nodo>();
	
	public AStar(int dim, int xinicio, int yinicio, int xfin, int yfin)
	{
		this.tablero = new Tablero(new Nodo(xinicio, yinicio),new Nodo(xfin,yfin), dim);
	}
	
	public void aplicarAlgoritmo()
	{
		Nodo nodoAExpandir = tablero.getInicio();
		boolean salir = false;
		//nodo inicio
		this.expandir(nodoAExpandir,this.ListaAbierta,this.ListaCerrada);
		nodoAExpandir.setHeuristica(nodoAExpandir.calcularHeuristica(this.tablero.getInicio(),this.tablero.getFin()));
		Collections.sort(ListaAbierta);
		nodoAExpandir = this.ListaAbierta.get(0);
		while(this.ListaAbierta.size() > 0 && !salir )
		{
			this.expandir(nodoAExpandir,this.ListaAbierta,this.ListaCerrada);
			Collections.sort(ListaAbierta);
			nodoAExpandir = this.ListaAbierta.get(0);
			if(this.comparaNodos(nodoAExpandir, this.tablero.getFin()))
			{
				this.ListaCerrada.add(nodoAExpandir);
				this.ListaAbierta.remove(nodoAExpandir);
				salir = true;
			}
		}
		this.mostrarRuta();
	}

	private void mostrarRuta() {
		Nodo nodoanterior = null;
		for(int i = this.ListaCerrada.size()-1; i >= 0;i--)
		{
			if(i == this.ListaCerrada.size()-1)
			{
				System.out.print(this.ListaCerrada.get(i));
				nodoanterior = this.ListaCerrada.get(i);
				this.Solucion.add(this.ListaCerrada.get(i));
			}
			else
			{
				if(this.comparaNodos(nodoanterior.getPadre(),this.ListaCerrada.get(i)))
				{
					System.out.print(this.ListaCerrada.get(i));
					nodoanterior = this.ListaCerrada.get(i);
					this.Solucion.add(this.ListaCerrada.get(i));
				} 
			} 
		}
		Collections.sort(Solucion);
		System.out.println("\n");
	}

	private void expandir(Nodo nodo, ArrayList<Nodo> listaAbierta, ArrayList<Nodo> listaCerrada) 
	{
			Nodo nodoATratar;
			for(int i = -1 ; i <= 1; i++)
			{
				for(int j = -1; j <= 1; j++)
				{
					nodoATratar = tablero.getNodo(nodo.getX()+i,nodo.getY()+j);
					if(nodoATratar != null)
					{
						if(!this.comparaNodos(nodo, nodoATratar) && !this.buscarEnLista(this.ListaCerrada,nodoATratar))
						{
							if(nodoATratar.getPonible() && this.estaEnRango(nodoATratar))
							{
								if(!this.buscarEnLista(ListaAbierta,nodoATratar))
								{
									nodoATratar.setPadre(nodo);
									nodoATratar.setHeuristica(nodoATratar.calcularHeuristica(this.tablero.getInicio(),this.tablero.getFin()));
									listaAbierta.add(nodoATratar);
								}
							}
						}
					}	
				}
				
			}
			listaCerrada.add(nodo);
			listaAbierta.remove(nodo);
	}

	private boolean estaEnRango(Nodo nodoATratar) {
		return (nodoATratar.getX() >= 0 && nodoATratar.getX() < this.tablero.getDim())
		&& (nodoATratar.getY() >= 0 && nodoATratar.getY() < this.tablero.getDim());
	}
	
	private boolean comparaNodos(Nodo nodo1, Nodo nodo2)
	{
		if (nodo1.getX() == nodo2.getX() && nodo1.getY() == nodo2.getY())
			return true;
		else return false;
	}
	
	private boolean buscarEnLista(ArrayList<Nodo> lista,Nodo n)
	{
		boolean salida= false;
		for(int i = 0; i < lista.size() && !salida; i++)
		{
			if(this.comparaNodos(lista.get(i), n))
				salida = true;;
		}
		return salida;
	}
	
	public void setObstaculo(int x, int y)
	{
		this.tablero.setObstaculo(x, y);
	}
	
}