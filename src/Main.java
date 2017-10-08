import java.util.Scanner;

public class Main {
	
	static Scanner consola = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		String lectura;
		int DIM = 0, Xinicio, Yinicio, Xfin, Yfin, numObstaculos, x ,y;
		do{
			try{
				System.out.print("Introduce Dimension: ");
				lectura = consola.next();
				DIM = Integer.parseInt(lectura);
				if(DIM < 2)
					throw new Exception("Error Dimension");
				
				System.out.print("Introduce (x y) del inicio: ");
				lectura = consola.next();
				Xinicio = Integer.parseInt(lectura);
				lectura = consola.next();
				Yinicio = Integer.parseInt(lectura);
				if(Xinicio < 0 || Xinicio >= DIM || Yinicio < 0 || Yinicio >= DIM)
					throw new Exception("Error Inicio");
				
				System.out.print("Introduce (x y) del fin: ");
				lectura = consola.next();
				Xfin= Integer.parseInt(lectura);
				lectura = consola.next();
				Yfin = Integer.parseInt(lectura);
				if(Xfin < 0 || Xfin >= DIM || Yfin < 0 || Yfin >= DIM)
					throw new Exception("Error Fin");
				
				System.out.print("Introduce numero de obstaculos: ");
				lectura = consola.next();
				
				numObstaculos = Integer.parseInt(lectura);
				AStar algoritmo = new AStar(DIM,Xinicio,Yinicio,Xfin,Yfin);
				for(int i = 0; i < numObstaculos; i++)
				{
					System.out.print("Obstaculo " + (i+1)  + " (x,y): ");
					lectura = consola.next();
					x = Integer.parseInt(lectura);
					lectura = consola.next();
					y = Integer.parseInt(lectura);
					algoritmo.setObstaculo(x, y);
					
				}

			
			algoritmo.aplicarAlgoritmo();
			}catch(Exception e){
				System.err.println(e.getMessage());
				System.getProperty("line.separator");
			};
	}while(DIM != 0);
		
 	}

}
