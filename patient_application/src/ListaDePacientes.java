
public class ListaDePacientes {

	private int proximoIndice;
	private Paciente [] lista;
	
	public ListaDePacientes(int tamanho) {
		lista = new Paciente[tamanho];
		proximoIndice = 0;
	}
	
	public boolean cadastraPaciente(Paciente p) {
		for (int i = 0; i < proximoIndice; i++) {
			if (lista[i].getCodigo() == p.getCodigo() || lista[i].getNome().equals(p.getNome())) {
				return false;
			}
		}
		lista[proximoIndice] = p;
		proximoIndice++;
		return true;
	}
	
	public Paciente consultaPorNome(String nome) {
		for(int i =0; i<proximoIndice; i++) {
			if(lista[i].getNome().equalsIgnoreCase(nome)) {
				return lista[i];
			}
		}
		return null;
	}
	
	public Paciente consultaPorCodigo(int codigo) {
		for(int i =0; i<proximoIndice; i++) {
			if(lista[i].getCodigo()==codigo) {
				return lista[i];
			}
		}
		return null;
	}
	
	 public void listaPacientesAcimaIdade(int idade) {
	        for (int i = 0; i < proximoIndice; i++) {
	            if (lista[i].getIdade() > idade) {
	            	System.out.println("Paciente[ " + (i+1) + " ]:\n" + lista[i]);
	            }
	            else
	            	System.out.println("Nenhum paciente encontrado");
	        }
	    }

	    public void listaTodosPacientes() {
	    	for (int i = 0; i < proximoIndice; i++) {
	        	System.out.println("Paciente[ " + (i+1) + " ]:\n" + lista[i]);
	        	return;
	        }
	    	System.out.println("Nenhum paciente cadastrado");
	    }
	    
	    public void alteraPeso(int codigo, double peso) {
	    	for (int i = 0; i < proximoIndice; i++) {
	    		if(lista[i].getCodigo()==codigo) {
	    			lista[i].setPeso(peso);
	    			System.out.println("Peso alterado com sucesso!");
	    			return;
	    		}
	    	}
	    	System.out.println("Paciente com o código " + codigo + " não foi encontrado no sistema");
	    }
	    public void alteraGenero(int codigo, char genero) {
	    	for (int i = 0; i < proximoIndice; i++) {
	    		if(lista[i].getCodigo()==codigo) {
	    			lista[i].setGenero(genero);;
	    			System.out.println("Gênero alterado com sucesso!");
	    			return;
	    		}
	    	}
	    	System.out.println("Paciente com o código " + codigo + " não foi encontrado no sistema");
	    }
	    
	    public void alteraAltura(int codigo, double altura) {
	    	for (int i = 0; i < proximoIndice; i++) {
	    		if(lista[i].getCodigo()==codigo) {
	    			lista[i].setAltura(altura);;
	    			System.out.println("Altura alterada com sucesso!");
	    			return;
	    		}
	    	}
	    	System.out.println("Paciente com o código " + codigo + " não foi encontrado no sistema"); 
	    }
	    
	    public void mostraIMC(Paciente p) {
	    	for (int i = 0; i < proximoIndice; i++) {
	    		if(lista[i].equals(p)) {
	    			System.out.println("IMC do paciente " + p.getNome() + ":\n" +
	                        p.calculaIMC(p.getPeso(), p.getAltura()));
	    			return;
	    		}
	    	}
	    	System.out.println("Paciente não encontrado");
	    }
	    
	    
}
