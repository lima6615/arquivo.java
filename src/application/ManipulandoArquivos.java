package application;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class ManipulandoArquivos {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o diretorito do arquivo: ");
		String path = sc.nextLine();
		
		//Fazendo listagem de arquivos e pastas
		File file = new File(path);
		
		File [] pastas = file.listFiles(File::isDirectory);
		
		for(File c:pastas) {
			System.out.println("Pastas: "+c);
		}
		
		File [] arquivos = file.listFiles(File::isFile);
		
		for(File c:arquivos) {
			System.out.println("arquivos: "+c);
		}
		
		//Criando uma subPasta no diretorio que o usuário digitar 
		boolean success = new File(path + "\\out").mkdir();
		
		System.out.println("SubPasta criado com sucesso: "+success);
		
		sc.close();
	}
}
