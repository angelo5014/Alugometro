INSERT INTO Situacao_Usuario (Id_Situacao_Usuario, Descricao) VALUES (0, 'INATIVO');
INSERT INTO Situacao_Usuario (Id_Situacao_Usuario, Descricao) VALUES (1, 'ATIVO');

INSERT INTO Usuario (Id_Usuario, Nome, Sobrenome, Email, Senha, Id_Situacao_Usuario)
       VALUES (SEQ_Usuario.nextVal, 'Administrador', 'Total', 'admin@alugometro.com.br', '21232f297a57a5a743894a0e4a801fc3', 1);
       
commit;