
public class Paciente {

	private int codigo;
	private int idade;
	private String nome;
	private char genero;
	private double peso;
	private double altura;
	
	public Paciente(int codigo, int idade, String nome, char genero, double peso, double altura) {
		this.codigo = codigo;
		this.idade = idade;
		this.nome = nome;
		this.genero = genero;
		this.peso = peso;
		this.altura = altura;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public static double calculaIMC(double peso, double altura) {
		return peso/(Math.pow(altura, 2));
	}
	
	public static double calculaPesoIdeal(int altura, char genero) {
		if (String.valueOf(genero).equalsIgnoreCase("F")) {
			return 62.1 * altura - 44.7;
		}
		else
			return 72.7 * altura - 58;
	}

	public String toString() {
		return "Paciente [codigo= " + codigo + ", idade= " + idade + ", nome= " + nome + ", genero= " + genero + ", peso= "
				+ peso + ", altura =" + altura + "]";
	}
	
	
}
