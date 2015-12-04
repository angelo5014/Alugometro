
Alter table Usuario Drop CONSTRAINT Usuario_Situacao_Usuario_FK;

Alter table Estado Drop CONSTRAINT Estado_Federacao_FK;
Alter table Cidade Drop CONSTRAINT Cidade_Estado_FK;

Alter table Anuncio Drop CONSTRAINT Anuncio_Usuario_FK;
Alter table Anuncio Drop CONSTRAINT Anuncio_Tipo_Imovel_FK;
Alter table Anuncio Drop CONSTRAINT Anuncio_Tipo_Acomodacao_FK;
Alter table Anuncio Drop CONSTRAINT Anuncio_Cidade_FK;
Alter table Anuncio Drop CONSTRAINT Anuncio_Foto_Capa_FK;
Alter table Anuncio Drop CONSTRAINT Anuncio_Situacao_FK;

Alter table Foto Drop CONSTRAINT Foto_Anuncio_FK;

Alter table Reserva Drop CONSTRAINT Reserva_Usuario_FK;
Alter table Reserva Drop CONSTRAINT Reserva_Anuncio_FK;
Alter table Reserva Drop CONSTRAINT Reserva_Situacao_Reserva_FK; 

Drop Index IX_Anuncio_Cidade;
Drop Index IX_Anuncio_Foto_Capa;
Drop Index IX_Anuncio_Situacao;
Drop Index IX_Anuncio_Tipo_Acomodacao;
Drop Index IX_Anuncio_Tipo_Imovel;
Drop Index IX_Anuncio_Usuario;

Drop Index IX_Cidade_Estado;
Drop Index IX_Estado_Federacao;

Drop Index IX_Foto_Anuncio;

Drop Index IX_Reserva_Anuncio;
Drop Index IX_Reserva_Situacao;
Drop Index IX_Reserva_Usuario;

Drop Index IX_Usuario_Situacao;
Drop Index IX_Usuario_Email_Senha_Situacao;
Drop Index IX_Usuario_Email_Permissao;

Alter table Usuario Drop CONSTRAINT Usuario_Email_UK;

DROP table Situacao_Usuario;
DROP table Situacao_Anuncio;
DROP table Situacao_Reserva;
DROP table Tipo_Acomodacao;
DROP table Tipo_Imovel;
DROP table Reserva;
DROP table Anuncio;
DROP table Foto;
DROP table Usuario;
DROP table Federacao;
DROP table Estado;
DROP table Cidade;

DROP SEQUENCE SEQ_Usuario;
DROP SEQUENCE SEQ_Anuncio;
DROP SEQUENCE SEQ_Reserva;
DROP SEQUENCE SEQ_Foto;

