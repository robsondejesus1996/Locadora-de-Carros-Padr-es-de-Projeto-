Aluno: Robson de Jesus
Trabalho de padr�es de projeto 
Script para cria��o das tabelas 

create table Cliente(
   codigoCliente integer not null UNIQUE,
   cpf varchar(50) not null,
   nome varchar(50)not null,
   cnh varchar(50)not null,
   fone varchar(50)not null,
   email varchar(50)not null,
   primary key(codigoCliente)
)

create table carro(
 codigoCarro integer not null UNIQUE, 
 placa varchar(100),
 marca varchar(100),
 modelo varchar(100),
 anoFabricacao Date,
 valor_km integer,
 primary key (codigoCarro)
);

create table locacao(
   codigoLocacao integer not null,
   quilometragem_saida integer not null,
   quilomentragem_retorno integer,
   data_locacao date not null,
   data_devolucao date,
   status varchar(50)  not null,
   codigoCliente integer  not null,
   codigoCarro integer not null,
   primary key(codigoLocacao),
   foreign key(codigoCliente) references cliente (codigoCliente),
   foreign key(codigoCarro) references carro(codigoCarro)
)

Caminhos para testar os endpoints
1)Criar Cliente
Caminho: http://localhost:8080/Trabalho/webresources/Cliente/Cliente/inserir
Ex: 

2)Listar todos os clientes
Caminho: http://localhost:8080/Trabalho/webresources/Cliente
Ex:  
3)Listar os clientes filtrando pelo cpf
Caminho: http://localhost:8080/Trabalho/webresources/Cliente/Cliente/get/1111
Ex: 

4)Update do cliente 
OBS: Passe o mesmo codigoCliente para pegar a altera��o
Caminho: http://localhost:8080/Trabalho/webresources/Cliente/Cliente/alterar
Ex: 




5) Deletar Cliente
OBS: S� � necess�rio passar o cpf do cliente no final do caminho de excluir. 
Caminho: http://localhost:8080/Trabalho/webresources/Cliente/Cliente/excluir/1111
Ex:





6) Listar todos os Carro
Caminho: http://localhost:8080/Trabalho/webresources/carro
Ex: 


7) Criar Carro
Caminho: http://localhost:8080/Trabalho/webresources/carro/Carro/inserir
Ex: 





8)Listar os carros, todos e filtrar pela placa
OBS: Informe no final do caminho a string da placa 
Caminho: http://localhost:8080/Trabalho/webresources/carro/Carro/get/EABC1
Ex:
9)Cadastrar uma loca��o/empr�stimo
Obs: Para cadastra uma loca��o coloque todos os campos, menos os campos de quilomentragem_retorno, e data_devolu��o. Pois esses campos n�o podem entrar agora. So na devolu��o do empr�stimo que vamos fazer um put de altera��o.
OBS: Sempre que for cadastrar um empr�stimo, coloque o campo status como indispon�vel. Pois so quando fizermos a devolu��o esse status tamb�m deve ser alterado para dispon�vel. 
Caminho: http://localhost:8080/Trabalho/webresources/locacao/LocacaoCadastrarEmprestimo/inserir
Ex: 
10)Cadastrar devolu��o de carro
OBS: Essa opera��o foi feita com um put, pois na hora de inserir n�o s�o passados alguns campos. Na hora da devolu��o de carro esses campos devem ser passadas para a altera��o.
Caminho: http://localhost:8080/Trabalho/webresources/locacao/LocacaoDevolucao/alterar
Ex:
11) Dever ter uma maneira de controlar se o carro est� alugado ou dispon�vel
OBS: Informe o c�digo do carro no final do caminho, nele vai estar todos os campos como zero, e o status do carro atualmente. Por isso na devolu��o deve-se alterar esse status.  
Caminho: http://localhost:8080/Trabalho/webresources/locacao/DisponibilidadeCarro/get/1
Ex: 





