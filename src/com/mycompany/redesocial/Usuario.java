package com.mycompany.redesocial;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

	private String nome; //atributo da classe

	ArrayList<Usuario> listaAmizades = new ArrayList<>(); // criacao da lista de amizades

	public Usuario(String nome) { // Construtor da classe
		this.nome = nome;
	}

	public Usuario() { // Construtor default
	}

	public String getNome() { // metodo get
		return nome;
	}

	public void setNome(String nome) {
		; // metodo set
		this.nome = nome;
	}

	public Usuario criarUsuario() { // metodo a ser implementado pelas classes filhas
		return null;
	}

	public void removerUsuario(ArrayList<Usuario> listaUsuarios, String nome) {
		for (Usuario u : listaUsuarios) { // percorre toda a lista
			if (u.getNome().equalsIgnoreCase(nome)) { // compara se o nome eh igual ao nome fornecido como parametro
				listaUsuarios.remove(u); // remove o usuario da lista
				break;
			}
		}
	}

	public void atualizarUsuario() { // metodo a ser implementado pelas classes filhas
	}

	public void imprimirUsuarios(ArrayList<Usuario> listaUsuarios) {
		for (Usuario u : listaUsuarios) { // percorre a lista em cada posicao
			System.out.println(u); // imprime um usuario
		}
	}

	public void criarAmizade(ArrayList<Usuario> listaUsuarios, String nomeUsuario) {
		boolean usuarioEncontrado = false;
		Scanner sc = new Scanner(System.in);
		for (Usuario u : listaUsuarios) {
			if (u.getNome().equalsIgnoreCase(nomeUsuario)) {
				System.out.println("\nCom quem deseja fazer amizade? ");
				String nomeAmigo = sc.nextLine(); // captura o nome digitado
				for (Usuario a : listaUsuarios) { // percorre a lista atras do usuario que possui esse nome
					if (a.getNome().equalsIgnoreCase(nomeAmigo)) { //
						u.listaAmizades.add(a); // adiciona o amigo encontrado na lista de amizades do usuario
						System.out.println("\nAgora voce e amigo de " + nomeAmigo + "!\n");
						usuarioEncontrado = true;
						break;
					}
				}
			}
		}
		if (usuarioEncontrado == false) { // caso nao encontre o usuario para fazer amizade
			System.out.println("Usuario nao encontrado!\n");
		}
	}

	public void removerAmizade(ArrayList<Usuario> listaUsuarios, String nomeUsuario) {
		boolean usuarioEncontrado = false;
		if (!listaAmizades.isEmpty()) {
			Scanner sc = new Scanner(System.in);
			for (Usuario u : listaUsuarios) {
				if (u.getNome().equalsIgnoreCase(nomeUsuario)) {
					System.out.println("\nCom quem deseja remover amizade? ");
					String nomeAmigo = sc.nextLine(); // captura o nome do amigo para remover
					for (Usuario a : listaAmizades) {
						if (a.getNome().equalsIgnoreCase(nomeAmigo)) {
							u.listaAmizades.remove(a); // remove o amigo da lista de amizades do usuario
							System.out.println("\nA amizade com " + nomeAmigo + " foi removida!\n");
							usuarioEncontrado = true;
							break;
						}
					}
				}
			}

			if (usuarioEncontrado == false) { // caso o amigo nao seja encontrado
				System.out.println("Esse usuario nao faz parte da sua lista de amigos!\n");
			}
		} else { // caso a lista de amizades esteja vazia
			System.out.println("\nVoce nao possui amigos para remover!\n");
		}
	}

	public void imprimirAmizade(ArrayList<Usuario> listaUsuarios, String nomeUsuario) {
		if (!listaAmizades.isEmpty()) {
			for (Usuario u : listaUsuarios) {
				if (u.getNome().equalsIgnoreCase(nomeUsuario)) { 
					System.out.println("Lista de amigos de " + u.getNome() + ":");
					for (Usuario a : listaAmizades) { // percorre a lista de amizades do usuario
						System.out.println(a.getNome()); // printa um amigo por vez da lista
					}
				}
			}
			System.out.println("\n");

		} else {
			System.out.println("\nVoce nao tem amigos atualmente!\n");
		}
	}
}