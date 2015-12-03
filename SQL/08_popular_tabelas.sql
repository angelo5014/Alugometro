--- Situações ---

--- Situacao_Usuario

INSERT INTO Situacao_Usuario (Id_Situacao_Usuario, Descricao) VALUES (0, 'INATIVO');
INSERT INTO Situacao_Usuario (Id_Situacao_Usuario, Descricao) VALUES (1, 'ATIVO');
	
---------------------
	
--- Situacao_Anuncio

INSERT INTO Situacao_Anuncio (Id_Situacao_Anuncio, Descricao) VALUES (0, 'INDISPONIVEL');
INSERT INTO Situacao_Anuncio (Id_Situacao_Anuncio, Descricao) VALUES (1, 'DISPONIVEL');
	
---------------------
	
--- Situacao_Reserva
	
INSERT INTO Situacao_Reserva (Id_Situacao_Reserva, Descricao) VALUES (0, 'PENDENTE');
INSERT INTO Situacao_Reserva (Id_Situacao_Reserva, Descricao) VALUES (1, 'PROCESSANDO');
INSERT INTO Situacao_Reserva (Id_Situacao_Reserva, Descricao) VALUES (2, 'ENCERRADA');
INSERT INTO Situacao_Reserva (Id_Situacao_Reserva, Descricao) VALUES (3, 'CANCELADA');
	
---------------------

--- Tipos ---

--- Tipo_Imovel

INSERT INTO Tipo_Imovel (Id_Tipo_Imovel, Descricao) VALUES (1, 'Apartamento');
INSERT INTO Tipo_Imovel (Id_Tipo_Imovel, Descricao) VALUES (2, 'Casa');
INSERT INTO Tipo_Imovel (Id_Tipo_Imovel, Descricao) VALUES (3, 'Pousada');
INSERT INTO Tipo_Imovel (Id_Tipo_Imovel, Descricao) VALUES (4, 'Chalé');
INSERT INTO Tipo_Imovel (Id_Tipo_Imovel, Descricao) VALUES (5, 'Chácara');
INSERT INTO Tipo_Imovel (Id_Tipo_Imovel, Descricao) VALUES (6, 'Cobertura');
INSERT INTO Tipo_Imovel (Id_Tipo_Imovel, Descricao) VALUES (7, 'Condomínio Fechado');
INSERT INTO Tipo_Imovel (Id_Tipo_Imovel, Descricao) VALUES (8, 'Salão');
INSERT INTO Tipo_Imovel (Id_Tipo_Imovel, Descricao) VALUES (9, 'Sobrado');

---------------------

--- Tipo_Acomodacao

INSERT INTO Tipo_Acomodacao (Id_Tipo_Acomodacao, Descricao) VALUES (1, 'Casa Inteiro');
INSERT INTO Tipo_Acomodacao (Id_Tipo_Acomodacao, Descricao) VALUES (2, 'Apartamento Inteiro');
INSERT INTO Tipo_Acomodacao (Id_Tipo_Acomodacao, Descricao) VALUES (3, 'Quarto Inteiro');
INSERT INTO Tipo_Acomodacao (Id_Tipo_Acomodacao, Descricao) VALUES (5, 'Quarto Compartilhado');
INSERT INTO Tipo_Acomodacao (Id_Tipo_Acomodacao, Descricao) VALUES (6, 'Quarto Casal');

-- Adicionar mais...
