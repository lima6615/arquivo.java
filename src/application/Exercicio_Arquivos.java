package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Exercicio_Arquivos {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.print("Entre com o caminho do arquivo: ");
		String path = sc.nextLine();

		File file = new File(path);
		String diretorio = file.getParent();

		boolean subPasta = new File(diretorio + "\\out").mkdir();

		String novoArquivo = diretorio + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while (line != null) {
				String[] arquivo = line.split(",");
				String name = arquivo[0];
				double price = Double.parseDouble(arquivo[1]);
				int quantity = Integer.parseInt(arquivo[2]);

				Product prod = new Product(name, price, quantity);
				list.add(prod);

				line = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(novoArquivo))) {

				for (Product c : list) {
					bw.write(c.getName() + ", " + String.format("%.2f", c.total()));
					bw.newLine();
				}
				
				System.out.println(novoArquivo +": Criado!");
			} catch (IOException e) {
				System.out.println("Erro em escrever o arquivo: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		sc.close();
	}
}
