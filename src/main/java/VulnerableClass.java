

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VulnerableClass {
	private Scanner console;
	private String scan;
	private String scan2;
	private boolean fazerOperacao;
	
	public VulnerableClass(){
		scan = "";
		fazerOperacao = true;
		
	}
	
	public String getScan1(){
		return scan;
	}
	
	public String getScan2(){
		return scan2;
	}
	
	public void vulnerableMethod(String FILENAME){
		while (fazerOperacao) {
		    console = new Scanner(System.in);
		    System.out.println("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, W para escrever em um arquivo>? ");
			
		    scan = console.nextLine();
		    
		    if (scan.equals("R")){
		    	fazerOperacao = false;
		    	
				BufferedReader br = null;
				FileReader fr = null;
				
				try {

					fr = new FileReader(FILENAME);
					br = new BufferedReader(fr);

					String sCurrentLine = "";

					br = new BufferedReader(new FileReader(FILENAME));

					sCurrentLine = br.readLine();
					
					while (sCurrentLine != null) {
						System.out.println(sCurrentLine);
						sCurrentLine = br.readLine();
					}

				} catch (IOException e) {

					e.printStackTrace();

				} 
			}
			
			else if(scan.equals("W")) {
				
				  fazerOperacao = false;
				  BufferedWriter buffWrite;
				  
				  try {
					buffWrite = new BufferedWriter(new FileWriter(FILENAME));
					String linha = "";
					System.out.println("Escreva algo: ");
				    linha = console.nextLine();
				    buffWrite.append(linha + "\n");
				     
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
			else {
				
				fazerOperacao = false;
				System.out.println("Digito inválido");
				
			}
		    
		    System.out.println("Outra operação?<digite S para sim, outro simbolo para não>");
		    scan2 = console.nextLine();
		    
		    if(scan2.equals("S"))
		    	fazerOperacao = true;
		}
	}
}
