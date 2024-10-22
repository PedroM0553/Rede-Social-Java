package com.mycompany.redesocial;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa extends Usuario { // declarando que Empresa esta herdando de Usuario

    private String ramo; // atributos da classe
    private String anuncio;

    public Empresa(String nome, String ramo, String anuncio) { // construtor da classe
        super(nome);
        this.ramo = ramo;
        this.anuncio = anuncio;
    }
    
    public Empresa(){ // construtor default
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(String anuncio) {
        this.anuncio = anuncio;
    }

    @Override
    public Usuario criarUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do usuario: ");
        String nome = sc.nextLine();
        System.out.print("Digite o ramo da empresa: ");
        String ramo = sc.nextLine();
        System.out.print("Digite o anuncio da empresa: ");
        String anuncio = sc.nextLine();
        System.out.println("O usuario " + nome + " foi criado!");
        return new Empresa(nome, ramo, anuncio);

    }
    
    @Override
    public void atualizarUsuario() {
    	Scanner sc = new Scanner(System.in);
		System.out.print("Novo nome: ");
		String novoNome = sc.nextLine();
		System.out.print("Novo ramo: ");
		String novoRamo = sc.nextLine();
		System.out.print("Novo anuncio: ");
		String novoAnuncio = sc.nextLine();
		this.setNome(novoNome);
    	this.setRamo(novoRamo);
    	this.setAnuncio(novoAnuncio);
    	System.out.println("\nAs informacoes do usuario " + novoNome + " foram atualizadas!\n");
    }

    @Override
    public void removerUsuario(ArrayList<Usuario> listaUsuarios, String nome) {
        super.removerUsuario(listaUsuarios, nome);
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
	public String toString() {
		return "\nEmpresa\nNome: " + this.getNome() +
			   "\nRamo: " + this.getRamo() +
			   "\nAnuncio: " + this.getAnuncio() + "\n";
	}
}