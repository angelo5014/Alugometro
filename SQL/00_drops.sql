
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

