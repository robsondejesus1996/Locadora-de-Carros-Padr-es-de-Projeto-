# Criação de banco de dados e End Points para fazer operações dos dados 
## Alunos: Robson de Jesus e Camila Masasneiro 


### Criação dos scrips do banco de dados
###### create table Cliente(
######   codigoCliente integer not null UNIQUE,
######   cpf varchar(50) not null,
######   nome varchar(50)not null,
######   cnh varchar(50)not null,
######   fone varchar(50)not null,
######   email varchar(50)not null,
######   primary key(codigoCliente)
)

###### create table carro(
###### codigoCarro integer not null UNIQUE, 
###### placa varchar(100),
###### marca varchar(100),
###### modelo varchar(100),
###### anoFabricacao Date,
###### valor_km integer,
###### primary key (codigoCarro)
);

###### create table locacao(
######   codigoLocacao integer not null,
######   quilometragem_saida integer not null,
######   quilomentragem_retorno integer,
######   data_locacao date not null,
######   data_devolucao date,
######   status varchar(50)  not null,
######   codigoCliente integer  not null,
######   codigoCarro integer not null,
######   primary key(codigoLocacao),
######   foreign key(codigoCliente) references cliente (codigoCliente),
######   foreign key(codigoCarro) references carro(codigoCarro)
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
OBS: Passe o mesmo codigoCliente para pegar a alteração
Caminho: http://localhost:8080/Trabalho/webresources/Cliente/Cliente/alterar
Ex: 




5) Deletar Cliente
OBS: Só é necessário passar o cpf do cliente no final do caminho de excluir. 
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
9)Cadastrar uma locação/empréstimo
Obs: Para cadastra uma locação coloque todos os campos, menos os campos de quilomentragem_retorno, e data_devolução. Pois esses campos não podem entrar agora. So na devolução do empréstimo que vamos fazer um put de alteração.
OBS: Sempre que for cadastrar um empréstimo, coloque o campo status como indisponível. Pois so quando fizermos a devolução esse status também deve ser alterado para disponível. 
Caminho: http://localhost:8080/Trabalho/webresources/locacao/LocacaoCadastrarEmprestimo/inserir
Ex: 
10)Cadastrar devolução de carro
OBS: Essa operação foi feita com um put, pois na hora de inserir não são passados alguns campos. Na hora da devolução de carro esses campos devem ser passadas para a alteração.
Caminho: http://localhost:8080/Trabalho/webresources/locacao/LocacaoDevolucao/alterar
Ex:
11) Dever ter uma maneira de controlar se o carro está alugado ou disponível
OBS: Informe o código do carro no final do caminho, nele vai estar todos os campos como zero, e o status do carro atualmente. Por isso na devolução deve-se alterar esse status.  
Caminho: http://localhost:8080/Trabalho/webresources/locacao/DisponibilidadeCarro/get/1
Ex: 





