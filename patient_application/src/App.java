import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao = 0, tamanho, codigo, idade;
		double altura, peso;
		char genero;
		String nome;
		System.out.println("Insira o tamanho da lista de pacientes:");
		tamanho = sc.nextInt();
		ListaDePacientes listaDePacientes = new ListaDePacientes(tamanho);
		
		do {
			menu();
			opcao = sc.nextInt();
			switch (opcao) {
			case 1: 
				do {
					System.out.println("Informe o nome do paciente:");
					sc.nextLine();
					nome = sc.nextLine();
					System.out.println("Informe o código do paciente");
					codigo = sc.nextInt();
					System.out.println("Informe o gênero do paciente (F ou M)");
					genero = Character.toUpperCase(sc.next().charAt(0));
					System.out.println("Informe a idade do paciente:[0; 120]");
					idade = sc.nextInt();
					System.out.println("Informe o peso, em kg, do paciente:(0; 150kg]");
					peso = sc.nextDouble();
					System.out.println("Informe a altura, em metros, do paciente:(0; 2,5m]");
					altura = sc.nextDouble();
				}while(codigo < 0 || nome == null || genero != 'F' && genero != 'M' || idade < 0 || idade > 120 
						|| peso <=0 || peso > 150 || altura <= 0 || altura > 2.5);
				Paciente p = new Paciente(codigo, idade, nome, genero, peso, altura);
				if (listaDePacientes.cadastraPaciente(p)) {
				    System.out.println("Paciente cadastrado com sucesso!");
				} else {
				    System.out.println("Erro ao cadastrar paciente. Já existe um paciente com esse código ou nome.");
				}
				break;
			
			case 2:
				System.out.println("Informe o nome do paciente:");
				nome = sc.next();
				if(listaDePacientes.consultaPorNome(nome)!= null) {
					System.out.println("Paciente encontrado: \n" + listaDePacientes.consultaPorNome(nome).toString());
				}
				else
					System.out.println("Paciente não encontrado.");
				break;
			
			case 3: 
				System.out.println("Informe o código do paciente:");
				codigo = sc.nextInt();
				if(listaDePacientes.consultaPorCodigo(codigo)!= null) {
					System.out.println("Paciente encontrado: \n" + listaDePacientes.consultaPorCodigo(codigo).toString());
				}
				else
					System.out.println("Paciente não encontrado.");
				break;
			
			case 4:
				System.out.println("Informe a idade mínima para consultar os pacientes: ");
				idade = sc.nextInt();
				listaDePacientes.listaPacientesAcimaIdade(idade);
				break;
				
			case 5:
				listaDePacientes.listaTodosPacientes();
                break;
                
			case 6:
				System.out.println("Informe o código do paciente:");
                codigo = sc.nextInt();
                do {
                	System.out.println("Informe o novo peso(0; 150kg]:");
                	peso = sc.nextDouble();
                }while(peso <= 0 || peso > 150);
                listaDePacientes.alteraPeso(codigo, peso);
                break;
                
			case 7:
				System.out.println("Informe o código do paciente:");
                codigo = sc.nextInt();
                do {
                	System.out.println("Informe a nova altura:(0; 2,5m]");
                	altura = sc.nextDouble();
                }while(altura <= 0 || altura > 2.5);
                listaDePacientes.alteraAltura(codigo, altura);
                break;
                
			case 8:
				System.out.println("Informe o código do paciente:");
                codigo = sc.nextInt();
                do {
                	System.out.println("Informe o novo gênero (F ou M):");
                	genero = Character.toUpperCase(sc.next().charAt(0));
                }while(genero != 'F' && genero != 'M');
                listaDePacientes.alteraGenero(codigo, genero);
                break;
                
			case 9:
				System.out.println("Informe o código do paciente:");
				codigo = sc.nextInt();
				if(listaDePacientes.consultaPorCodigo(codigo)!= null) {
					listaDePacientes.mostraIMC(listaDePacientes.consultaPorCodigo(codigo));
				}
				break;
				
			case 0:
                System.out.println("Saindo do programa...");
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
			}
	
		}while(opcao!=0);
	}
	public static void menu() {
		System.out.println("Menu:\n");
		System.out.println("Escolha uma opção: ");
        System.out.println("1. Cadastrar Paciente");
        System.out.println("2. Consultar Paciente por Nome");
        System.out.println("3. Consultar Paciente por Código");
        System.out.println("4. Listar Pacientes Acima de uma Idade");
        System.out.println("5. Listar Todos os Pacientes");
        System.out.println("6. Alterar Peso de um Paciente");
        System.out.println("7. Alterar Altura de um Paciente");
        System.out.println("8. Alterar Sexo de um Paciente");
        System.out.println("9. Mostrar IMC de um Paciente");
        System.out.println("0. Sair");
	}
}
