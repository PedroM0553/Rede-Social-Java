package com.mycompany.redesocial;

import java.util.ArrayList; // import para permitir a utilizacao de Collections
import java.util.Scanner; // import para permitir a utilizacao do Scanner (input)

public class Test{

	public static void main(String[] args) {
    	ArrayList<Usuario> listaUsuarios = new ArrayList<>(); // cria a lista de usuarios
    	
    	// iniciando os objetos que serao manipulados
    	Usuario usuario = new Usuario();    
    	Pessoa p = new Pessoa();
    	Empresa e = new Empresa();
    	
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1 - Login/Cadastro de usuario;\n" +
                               "2 - Atualizar usuario;\n" +
                               "3 - Remover usuario;\n" +
                               "4 - Imprimir usuarios;\n" +
                               "5 - Fazer amizade\n" +
                               "6 - Remover amizade\n" +
                               "7 - Imprimir amizades\n" +
                               "8 - Sair");
            
            int op = sc.nextInt(); // usuario digita a opcao desejada
            sc.nextLine();
            switch(op){
                case 1:
                    System.out.print("\nLogin: ");
                    String nomeLogin = sc.nextLine();
                    boolean usuarioEncontrado = false;
                    for(Usuario u : listaUsuarios) { // percorre a lista procurando o usuario escolhido
                    	if(u.getNome().equalsIgnoreCase(nomeLogin)) { // se o nome for igual ao digitado:
                    		System.out.println("Bem vindo " + u.getNome() + "\n");
                    		usuario = u; // atribui o usuario encontrado ao objeto usuario, que sera manipulado no resto do sistema
                    		usuarioEncontrado = true;
                    		break;
                    	}
                    }
                    if(usuarioEncontrado == false) { // caso o usuario nao tenha sido encontrado
                    	System.out.println("\nSeu usuario ainda nao existe!\nCadastre-se:");
                        System.out.println("1 - Pessoa\n2 - Empresa");
                        int opcao = sc.nextInt(); // captura escolha do usuario
                        sc.nextLine();
                        if(opcao == 1){
                        	Usuario pessoa = p.criarUsuario(); // criacao de nova pessoa
                            listaUsuarios.add(pessoa); // adicinando a pessoa na lista de usuarios
                            System.out.println("\n");
                        }else if(opcao == 2){
                        	Usuario empresa = e.criarUsuario(); // criacao de uma nova empresa
                            listaUsuarios.add(empresa); // adicinando a empresa na lista de usuarios
                            System.out.println("\n");
                        }else{
                            System.out.println("Opcao invalida!\n"); // caso o usuario digite outra opcao
                        }
                        break;
                    }else {
                    	break;
                    }
                
                case 2:
                	if (usuario.getNome() != null) { // verifica se o usuario fez login
	                	System.out.println("\nAtualizacao do usuario");
	                	if(usuario instanceof Pessoa) { // caso o objeto tratado seja uma instancia de pessoa
	                		((Pessoa) usuario).atualizarUsuario(); // metodo de atualizar o objeto
	                	}else if(usuario instanceof Empresa) { // caso o objeto tratado seja uma instancia de empresa
	                		((Empresa) usuario).atualizarUsuario();
	                	}
	                	break;
                	}
                	System.out.println("\nPara atualizar o usuario, primeiro faca login!\n"); // caso o usuario nao tennha feito login
                    break;
                    
                case 3:
                	if (usuario.getNome() != null) {
                		usuario.removerUsuario(listaUsuarios, usuario.getNome()); // metodo de remover o usuario da lista de usuarios
                    	System.out.println("O usuario " + usuario.getNome() + " foi removido!\n");
                    	break;
                	}
                	System.out.println("\nPara excluir, primeiro faca login!\n");
                	break;
                	
                case 4:
                	if (usuario.getNome() != null) {
                		usuario.imprimirUsuarios(listaUsuarios); // imprime todos os usuarios presentes na lista
                        break;
                	}
                	System.out.println("\nPara imprimir os usuarios, primeiro faca login!\n");
                    break;
                    
                case 5:
                	if (usuario.getNome() != null) {
                		usuario.criarAmizade(listaUsuarios, usuario.getNome()); //cria amizade com outro usuario
                		break;
                	}
                	System.out.println("\nPara criar amizades, primeiro faca login!\n");
                	break;
                	
                case 6:
                	if (usuario.getNome() != null) {
                		usuario.removerAmizade(listaUsuarios, usuario.getNome()); //remove amizade
                		break;
                	}
                	System.out.println("\nPara remover amizades, primeiro faca login!\n");
                	break;
                	
                case 7: 
                	if (usuario.getNome() != null) {
                		usuario.imprimirAmizade(listaUsuarios, usuario.getNome()); // imprime a lista de amizades do objeto tratado
                		break;
                	}
                	System.out.println("\nPara imprimir amizades, primeiro faca login!\n");
                	break;
                	
                case 8:
                	System.out.println("Saindo do sistema...");
                	return;
                
                default:
                	System.out.println("Opcao invalida!\n");
            }
        }while(true);
    }
}