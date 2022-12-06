
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;



public class ThreadLigar  extends Thread {

	private static boolean estado;
	private static Vector clientes;
	private static Socket conexao;
	
	
	private volatile  boolean fim = false;  
	
	public ThreadLigar(Socket s) {
		super();
	
		conexao = s;
	
		
	}

	public void run(){
		
	
		
			try
			{
				// criando um socket que fica escutando a porta 2222.
				ServerSocket s = new ServerSocket(2222);
				//servidor.bind(new InetSocketAddress("192.168.5.1", 0));
				
				// Loop principal.
				while (true){
					// aguarda algum cliente se conectar. A execução do
					// servidor fica bloqueada na chamada do metodo accept da
					// classe ServerSocket. Quando algum cliente se conectar
					// ao servidor, o metodo desbloqueia e retorna com um
					// objeto da classe Socket, que é a porta da comunicação
					System.out.print("Esperando alguem se conectar...");
					Socket conexao = s.accept();
					System.out.println(" Jogador Conectou!");

					Socket cliente = s.accept();
			        System.out.println("Nova conexão com o cliente " +  
			            conexao.getInetAddress().getHostAddress()
			        );

			        Scanner s1 = new Scanner(conexao.getInputStream());
			        while (s1.hasNextLine()) {
			            System.out.println(s1.nextLine());
			        }

		
					
					
					
					ThreadServidor.inicio(conexao);
					

					// cria uma nova thread para tratar essa conexão
					

					// voltando ao loop, esperando mais alguem se conectar.
				}
			}
			
			catch (IOException e)
			{
				// caso ocorra alguma exceção de E/S, mostre qual foi.
				System.out.println("IOException: " + e);
			}
			
		
		
	}
		
		

	
	public  void setFim() { 
		
	    fim = true; 
	    System.out.println("Desligou" + fim);
	}  

	
	

}
