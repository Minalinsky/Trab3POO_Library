# Trab3POO_Library

//Alyson Matheus Maruyama Nascimento - 8532269
//Augusto de Paula Freitas - 8937191

Trabalho 3 da disciplina Programação Orientada a Objetos: Implementação de um sistema de biblioteca em JAVA

Link para a descrição do trabalho: https://waa.ai/veNE

************************************************************************************************************
									IMPORTANTE!!
									
		- O Trab3POO_Library.jar deve estar no mesmo diretório de todos os outros arquivos *.csv para
		funcionar adequadamente, mesmo que estes estejam em branco.
		- Arquivos *.csv: Bans.csv, Books.csv, Loans.csv, Users.csv
************************************************************************************************************


### Intruções:  
-Ao rodar/executar o programa, uma tela inicial será aberta solicitando a data atual de operação da biblioteca.
-A data deve ser fornecida pelo usuário no seguinte formato: dd/mm/yyyy. Exemplo: a data 01/02/2015 corresponde ao dia 01 de Fevereiro de 2015.
-Ao clicar no botão "Ok", uma segunda tela será aberta. Nessa tela encontramos todas as funções necessárias para o funcionamento da biblioteca imprementada (cadastro de usuários, cadastros de livros, listar emprestimos, etc.).
				
-Para registrar uma pessoa no sistema da biblioteca, o usuário deve digitar as informações corretas nos campos correspondentes à coluna denominada "Register Users" e depois pressionar o botão "Register". Para isso ele deve preencher:
                                1- em "Name" o nome da pessoa a ser cadastrada.
                                2- em "RG" o número de registro da pessoa.
                                3- em "Type" o tipo do usuario a ser cadastrado. Esse campo aceita apenas 6 valores como entrada:
                                "student"/"Student","community"/"Community","teacher"/"Teacher"
                                
-Para registrar um Livro no sistema da biblioteca, o usuário deve digitar as informações corretas nos campos correspondentes à coluna denominada "Register Books" e depois pressionar o botão "Register". Para isso ele deve preencher:
                                1- em "Title" o título do livro a ser adicionado
				2- em "Author" o nome do autor
				3- em "Type" o tipo do livro, podendo ser "Text"/"text" ou "General"/"general". Titulos repetidos não são aceitos
								
-Para registrar um empréstimo ou devolução de livros no sistema da biblioteca, o usuário também deverá digitar as informações corretas nos campos correspondentes à coluna denominada "Register / Return Loan" e depois pressionar o botão "Register". Para isso ele deve preencher:
                                1- em "RG" o numero de registro do usuário que irá fazer o(a) empréstimo/devolução.
				2- em "Title" o título do livro sob qual a operação será realizada.
				3- em "Type" a ação a ser realizada. Pode ser "Loan"/"loan", "Devolution"/"devolution".
							
- Para visualizar A lista de usuários/livros cadastrados, ou a lista de empréstimos que faltam a ser devolvidos, basta clicar nos seus respectivos botões ("See all the Users/Books/Loans");
								
**OBS:** O programa controla o sistema de biblioteca usando 4 arquivos no formato .csv. Em "Users.csv" temos o registro de todos os usuários cadastrados, em "Books.csv", os livros cadastrados, em "Loans.csv" a lista de empréstimos ainda não devolvidos, e em "Bans.csv", a lista de usuários suspensos (e a data de até quando estarão suspensos).
				
				
**OBS:** Os arquivos usados pelo programa estão estruturados com os seguintes campos, nas respectivas ordens:
					
					Books.csv
					Name, Author, Type

					Loans.csv
					RG, Title, returnDate(data limite para entrega)

					Users.csv
					Name, RG, Type

					Bans.csv
					RG, banDate(data até quando o usuario estará banido)
