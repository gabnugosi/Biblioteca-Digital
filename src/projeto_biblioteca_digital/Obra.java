package projeto_biblioteca_digital;

public class Obra {
	private int id;
	private String nome;
	private int edicao;
	private String tombo;
	private String ano;

	public Obra(int id, String nome, int edicao, String tombo, String ano) {
		super();
		this.id = id;
		this.nome = nome;
		this.edicao = edicao;
		this.tombo = tombo;
		this.ano = ano;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getTombo() {
		return tombo;
	}

	public void setTombo(String tombo) {
		this.tombo = tombo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

}
