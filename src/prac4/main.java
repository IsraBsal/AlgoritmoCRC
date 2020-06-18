package prac4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {


	public static void main(String args[]) throws FileNotFoundException, IOException{
		int indice_arreglo=0;
		int a=0;
		int contador_while=0;
		Scanner sc = new Scanner(System.in);
		//Input Data Stream
		/*System.out.print("Enter data stream: ");
		String datastream = sc.nextLine();*/
	
		//Leemos el txt e imprimimos letra por letra
		System.out.println("Leyendo txt...\n");
		char[] palabra = leeArchivo("C:\\Users\\is_ga\\Documents\\redes\\hola.txt"); //Arreglo que contiene todas las palabras del archivo txt //Aqui deben de cambiar la ruta a donde esta su archivo txt
		char[] palabra_de2=new char[2]; //Areglo usado para tomar solo 2 letras de la palabra original del txt
		int[] checksun1=new int[120];
		int[] checksun2=new int[144];
		//Para checar el arreglo
		System.out.println("Descomponiendo el txt en un arreglo de char");
		for  (int x=0; x<palabra.length; x++) {
			System.out.print(palabra[x]);
			System.out.println();
		}
		//Termina

		//Metemos el generador
		String generator = "100000101";
		System.out.println("generador en formato binario= "+generator);
		//Termina generador
		//System.out.println("El tamano de la palabra hola mundo es: "+palabra.length);
		System.out.println();
		System.out.println();
		if(palabra.length%2==0) {
			while(indice_arreglo<9) {

				//System.out.println("Valor de indice en la vuelta del while "+indice_arreglo);

				for(int j=0;j<2;j++) {
					//System.out.println("valor de j= "+j);
					palabra_de2[j]=palabra[indice_arreglo];
					indice_arreglo++;
				}
				//Imprimimos el Areglo de 2 posiciones
				//System.out.println("Esta es la palabra del arreglo palabra 2");

				/*for(int i=0;i<palabra_de2.length;i++) 
					System.out.print(palabra_de2[i]);
				System.out.println("");*/
				//Termina

				String datastream = String.valueOf(palabra_de2);
				System.out.println("Palabra a transmitir: "+datastream);
				datastream=convertirBinario(datastream);
				//System.out.println("Convirtiendo la palabra a binario es: "+datastream);


				int data[] = new int[datastream.length() + generator.length() - 1];
				int divisor[] = new int[generator.length()];
				char nada=' ';
				for(int i=0;i<datastream.length();i++) {
					if(nada == datastream.charAt(i)) {
						//System.out.println("Entre al if del caracter nada, esto es lo que arrojo: "+datastream.charAt(i));
					}
					if(nada != datastream.charAt(i)) {
						//System.out.println("Entre al caso donde no hay un espacio en blanco, esto hay: "+datastream.charAt(i));
						data[i] = Integer.parseInt(datastream.charAt(i)+"");
					}


				}

				for(int i=0;i<generator.length();i++)
					divisor[i] = Integer.parseInt(generator.charAt(i)+"");

				//Imprimir el arreglo de data a dividir
				System.out.print("Mensaje a transmitir: ");//Aqui ya contiene el residuo
				for(int i=0;i<data.length;i++) 
					System.out.print(data[i]);
				System.out.println();
				//termina

				//Imprimir el arreglo de divisor 
				System.out.print("Polinomio generador: ");
				for(int i=0;i<divisor.length;i++) 
					System.out.print(divisor[i]);
				System.out.println();
				//Termina



				//Calcula CRC
				for(int i=0;i<datastream.length();i++){
					if(data[i]==1)
						for(int j=0;j<divisor.length;j++)
							data[i+j] ^= divisor[j];
				}
				System.out.println();
				//Termina de calcular CRC



				//Mostramos CRC
				System.out.print("T(x)= ");
				/*for(int i=0;i<datastream.length();i++)
					data[i] = Integer.parseInt(datastream.charAt(i)+"");*/
				for(int i=0;i<datastream.length();i++) {
					if(nada == datastream.charAt(i)) {
						//System.out.println("Entre al if del caracter nada, esto es lo que arrojo: "+datastream.charAt(i));
					}
					if(nada != datastream.charAt(i)) {
						//System.out.println("Entre al caso donde no hay un espacio en blanco, esto hay: "+datastream.charAt(i));
						data[i] = Integer.parseInt(datastream.charAt(i)+"");
					}


				}
				for(int i=0;i<data.length;i++) 
					System.out.print(data[i]);
				System.out.println();

				//System.out.println("Termine una vuelta de while");
				//indice_arreglo++;

				//Comienza a construirse el arreglo checksun1
				if(contador_while==0) {
					for(int i=0;i<checksun1.length;i++) {
						checksun1[i]=0;
					}
					System.arraycopy(data, 0, checksun1, 0, 24);
					contador_while++;
				}
				else {
					System.arraycopy(data, 0, checksun1, a=a+24, 24);
					contador_while++;
				}

			


				System.out.println();
				System.out.println("--------------------------------------------------------------------------------------------------------------");
				System.out.println();
				System.out.println();
				System.out.println();



			}
		
			//Imprimimos el arreglo checksun
			System.out.println("Imprimiendo el arreglo checksun");
			for(int i=0;i<checksun1.length;i++) {
				System.out.print(checksun1[i]);
			}
			System.out.println();
			System.out.print("Tamano del checksun= "+checksun2.length);
			//Terminamos de imprimir
		
		
		}
		else {


			char []palabra2= new char[12];
			palabra2[11]='ÿ';
			for(int i=0;i<palabra2.length-1;i++) {
				palabra2[i]=palabra[i];
			}



			while(indice_arreglo<11) {
				//System.out.println("Valor de indice en la vuelta del while "+indice_arreglo);

				for(int j=0;j<2;j++) {
					//System.out.println("valor de j= "+j);
					palabra_de2[j]=palabra2[indice_arreglo];
					indice_arreglo++;
				}
				//Imprimimos el Areglo de 2 posiciones
				/*System.out.println("Esta es la palabra del arreglo palabra 2");
				for(int i=0;i<palabra_de2.length;i++) 
					System.out.print(palabra_de2[i]);
				System.out.println("");*/
				//Termina

				String datastream = String.valueOf(palabra_de2);
				System.out.println("Palabra a transmitir: "+datastream);
				datastream=convertirBinario(datastream);
				//System.out.println("Convirtiendo la palabra a binario es: "+datastream);


				int data[] = new int[datastream.length() + generator.length() - 1];
				int divisor[] = new int[generator.length()];
				char nada=' ';
				for(int i=0;i<datastream.length();i++) {
					if(nada == datastream.charAt(i)) {
						//System.out.println("Entre al if del caracter nada, esto es lo que arrojo: "+datastream.charAt(i));
					}
					if(nada != datastream.charAt(i)) {
						//System.out.println("Entre al caso donde no hay un espacio en blanco, esto hay: "+datastream.charAt(i));
						data[i] = Integer.parseInt(datastream.charAt(i)+"");
					}


				}

				for(int i=0;i<generator.length();i++)
					divisor[i] = Integer.parseInt(generator.charAt(i)+"");

				//Imprimir el arreglo de data a dividir
				System.out.print("Mensaje a transmitir: ");
				for(int i=0;i<data.length;i++) 
					System.out.print(data[i]);
				System.out.println();
				//termina

				//Imprimir el arreglo de divisor 
				System.out.println("Polinomio generador: ");
				for(int i=0;i<divisor.length;i++) 
					System.out.print(divisor[i]);
				System.out.println();
				//Termina



				//Calculation of CRC
				for(int i=0;i<datastream.length();i++){
					if(data[i]==1)
						for(int j=0;j<divisor.length;j++)
							data[i+j] ^= divisor[j];
				}
				System.out.println();




				//Imprimir CRC
				System.out.print("T(x)= ");
				/*for(int i=0;i<datastream.length();i++)
					data[i] = Integer.parseInt(datastream.charAt(i)+"");*/
				for(int i=0;i<datastream.length();i++) {
					if(nada == datastream.charAt(i)) {
						//System.out.println("Entre al if del caracter nada, esto es lo que arrojo: "+datastream.charAt(i));
					}
					if(nada != datastream.charAt(i)) {
						//System.out.println("Entre al caso donde no hay un espacio en blanco, esto hay: "+datastream.charAt(i));
						data[i] = Integer.parseInt(datastream.charAt(i)+"");
					}


				}
				for(int i=0;i<data.length;i++) 
					System.out.print(data[i]);
				System.out.println();
				//Termino imprimir CRC

				//System.out.println("Termine una vuelta de while");
				//indice_arreglo++;



				if(contador_while==0) {
					for(int i=0;i<checksun2.length;i++) {
						checksun2[i]=0;
					}
					System.arraycopy(data, 0, checksun2, 0, 24);
					contador_while++;
				}
				else {
					System.arraycopy(data, 0, checksun2, a=a+24, 24);
					contador_while++;
				}

				System.out.println();
				System.out.println("--------------------------------------------------------------------------------------------------------------");
				System.out.println();
				System.out.println();
				System.out.println();
			}


			//Imprimimos el arreglo checksun2
			System.out.println("Imprimiendo el arreglo checksun");
			for(int i=0;i<checksun2.length;i++) {
				System.out.print(checksun2[i]);
			}
			System.out.println();
			System.out.print("Tamano del checksun= "+checksun2.length);

		}




		//String datastream=palabra.toString();


	}

	static char[] leeArchivo(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		char palabraarr[];
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine())!=null) {
			System.out.println("La palabra del txt es: "+cadena);
			return palabraarr=cadena.toCharArray();
		}
		b.close();
		return palabraarr=cadena.toCharArray();
	}

	static String convertirBinario(String parCadena) {
		/*byte[] bytes = code.getBytes();
		StringBuilder binary = new StringBuilder();
		for (byte b : bytes)
		{
			int val = b;
			for (int i = 0; i < 8; i++)
			{
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
			binary.append(' ');
		}

		return binary.toString();*/

		String cadenaBinaria="";
		int longitud;

		longitud = parCadena.length();

		for(int i=0;i<longitud;i++){
			cadenaBinaria += String.format("%8s", Integer.toBinaryString(parCadena.charAt(i)));
			//System.out.println("cadChar: "+parCadena.charAt(i));
		}

		return cadenaBinaria;
	}







}

