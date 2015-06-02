# Trab3POO_Library

//Alyson Matheus Maruyama Nascimento - 8532269
//Augusto de Paula Freitas - 8937191

Trabalho 3 da disciplina Programa��o Orientada a Objetos: Implementa��o de um sistema de biblioteca em JAVA

Link para a descri��o do trabalho: https://waa.ai/veNE

************************************************************************************************************
									IMPORTANTE!!
									
		- O Trab3POO_Library.jar deve estar no mesmo diret�rio de todos os outros arquivos *.csv para
		funcionar adequadamente, mesmo que estes estejam em branco.
		- Arquivos *.csv: Bans.csv, Books.csv, Loans.csv, Users.csv
************************************************************************************************************


Intru��es:      -Ao rodar/executar o programa, uma tela inicial ser� aberta solicitando a data atual de opera��o da biblioteca.
                -A data deve ser fornecida pelo usu�rio no seguinte formato: dd/mm/yyyy. Exemplo: a data 01/02/2015 corresponde ao
                dia 01 de Fevereiro de 2015.
                -Ao clicar no bot�o "Ok", uma segunda tela ser� aberta. Nessa tela encontramos todas as fun��es necess�rias para o 
                funcionamento da biblioteca imprementada (cadastro de usu�rios, cadastros de livros, listar emprestimos, etc.).
				
                -Para registrar uma pessoa no sistema da biblioteca, o usu�rio deve digitar as informa��es corretas nos campos 
                correspondentes � coluna denominada "Register Users" e depois pressionar o bot�o "Register". Para isso ele deve preencher:
                                1- em "Name" o nome da pessoa a ser cadastrada.
                                2- em "RG" o n�mero de registro da pessoa.
                                3- em "Type" o tipo do usuario a ser cadastrado. Esse campo aceita apenas 6 valores como entrada:
                                "student"/"Student", 
								"community"/"Community", 
								"teacher"/"Teacher"
                                
                -Para registrar um Livro no sistema da biblioteca, o usu�rio deve digitar as informa��es corretas nos campos 
                correspondentes � coluna denominada "Register Books" e depois pressionar o bot�o "Register". Para isso ele deve preencher:
                                1- em "Title" o t�tulo do livro a ser adicionado
								2- em "Author" o nome do autor
								3- em "Type" o tipo do livro, podendo ser "Text"/"text" ou "General"/"general". Titulos repetidos
								n�o s�o aceitos
								
				-Para registrar um empr�stimo ou devolu��o de livros no sistema da biblioteca, o usu�rio tamb�m dever� digitar as 
				informa��es corretas nos campos correspondentes � coluna denominada "Register / Return Loan" e depois pressionar o
				bot�o "Register". Para isso ele deve preencher:
                                1- em "RG" o numero de registro do usu�rio que ir� fazer o(a) empr�stimo/devolu��o.
								2- em "Title" o t�tulo do livro sob qual a opera��o ser� realizada.
								3- em "Type" a a��o a ser realizada. Pode ser "Loan"/"loan", "Devolution"/"devolution".
							
				- Para visualizar A lista de usu�rios/livros cadastrados, ou a lista de empr�stimos que faltam a ser devolvidos, basta clicar
				nos seus respectivos bot�es ("See all the Users/Books/Loans");
								
				OBS: O programa controla o sistema de biblioteca usando 4 arquivos no formato *.csv. Em "Users.csv" temos o registro de todos os
				usu�rios cadastrados, em "Books.csv", os livros cadastrados, em "Loans.csv" a lista de empr�stimos ainda n�o devolvidos, e em
				"Bans.csv", a lista de usu�rios suspensos (e a data de at� quando estar�o suspensos).
				
				
				OBS: Os arquivos usados pelo programa est�o estruturados com os seguintes campos, nas respectivas ordens:
					
					Books.csv
					Name, Author, Type

					Loans.csv
					RG, Title, returnDate(data limite para entrega)

					Users.csv
					Name, RG, Type

					Bans.csv
					RG, banDate(data at� quando o usuario estar� banido)