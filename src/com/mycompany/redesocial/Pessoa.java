
package com.mycompany.redesocial;

import java.util.ArrayList;
import java.util.Scanner;

public class Pessoa extends Usuario { // declarando que Pessoa esta herdando de Usuario

    private int idade; // atributo da classe

    public Pessoa(String nome, int idade) { // construtor da classe
        super(nome); // utiliza-se o super para puxar um atributo da classe pai
        this.idade = idade;
    }
    
    public Pessoa(){ // construtor default
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override // anotacao override para indicar que esse metodo esta sendo herdado
    public Usuario criarUsuario() { // sobrescrevendo o metodo da classe pai/superclasse
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da pessoa: ");
        String nome = sc.nextLine();
        System.out.println("Digite a idade da pessoa: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println("O usuario " + nome + " foi criado!");
        return new Pessoa(nome, idade); // retorna um novo objeto do tipo pessoa
    }

    @Override
    public void atualizarUsuario() { // sobrescrevendo o metodo da classe pai/superclasse
        Scanner sc = new Scanner(System.in);
		System.out.print("Novo nome: ");
		String novoNome = sc.nextLine();
		System.out.print("Nova idade: ");
		int novaIdade = sc.nextInt();
		sc.nextLine();
    	this.setNome(novoNome); // vai setar as novas informacoes do usuario manipulado
    	this.setIdade(novaIdade);
    	System.out.println("\nAs informacoes do usuario " + novoNome + " foram atualizadas!\n");
    }

    @Override
    public void removerUsuario(ArrayList<Usuario> listaUsuarios, String nome) {
        super.removerUsuario(listaUsuarios, nome);
    }
    
    @Override
    public void imprimirUsuarios(ArrayList<Usuario> listaUsuarios) {
    	super.imprimirUsuarios(listaUsuarios);
    }
    
    @Override
    public void criarAmizade(ArrayList<Usuario> listaUsuarios, String nomeUsuario) {
        super.criarAmizade(listaUsuarios, nomeUsuario);
    }

    @Override
    public void imprimirAmizade(ArrayList<Usuario> listaUsuarios, String nomeUsuario) {
        super.imprimirAmizade(listaUsuarios, nomeUsuario);
    }

    @Override
    public void removerAmizade(ArrayList<Usuario> listaUsuarios, String nomeUsuario) {
        super.removerAmizade(listaUsuarios, nomeUsuario);
    }

	@Override
	public String toString() { // metodo toString para permitir printar diretamente um objeto
		return "\nPessoa\nNome: " + this.getNome() +
			   "\nIdade: " + this.getIdade() + "\n";
	}
    
    
}
