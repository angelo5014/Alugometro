--------Chaves Estrangeiras (FKs)---------

---------Usuario---------

Alter table Usuario 
	Add CONSTRAINT Usuario_Situacao_Usuario_FK FOREIGN KEY (Id_Situacao_Usuario) REFERENCES Situacao_Usuario (Id_Situacao_Usuario);


---------País/Estado/Cidade---------

Alter table Estado 
	Add CONSTRAINT Estado_Federacao_FK FOREIGN KEY (Id_Federacao) REFERENCES Federacao (Id_Federacao);


Alter table Cidade 
	Add CONSTRAINT Cidade_Estado_FK FOREIGN KEY (Id_Estado) REFERENCES Estado (Id_Estado);


---------Anúncio---------

Alter table Anuncio 
	Add (
		CONSTRAINT Anuncio_Usuario_FK FOREIGN KEY (Id_Usuario) REFERENCES Usuario (Id_Usuario),
 		CONSTRAINT Anuncio_Tipo_Imovel_FK FOREIGN KEY (Id_Tipo_Imovel) REFERENCES Tipo_Imovel (Id_Tipo_Imovel),
 		CONSTRAINT Anuncio_Tipo_Acomodacao_FK FOREIGN KEY (Id_Tipo_Acomodacao) REFERENCES Tipo_Acomodacao (Id_Tipo_Acomodacao),
 		CONSTRAINT Anuncio_Cidade_FK FOREIGN KEY (Id_Cidade) REFERENCES Cidade (Id_Cidade),
 		CONSTRAINT Anuncio_Foto_Capa_FK FOREIGN KEY (Id_Foto_Capa) REFERENCES Foto (Id_Foto),
 		CONSTRAINT Anuncio_Situacao_FK FOREIGN KEY (Id_Situacao_Anuncio) REFERENCES Situacao_Anuncio (Id_Situacao_Anuncio)
 		 );

---------Fotos---------

Alter table Foto
	Add CONSTRAINT Foto_Anuncio_FK FOREIGN KEY (Id_Anuncio) REFERENCES Anuncio (Id_Anuncio);


---------Reserva---------
Alter table Reserva
	Add(
		CONSTRAINT Reserva_Usuario_FK FOREIGN KEY (Id_Usuario) REFERENCES Usuario (Id_Usuario),
		CONSTRAINT Reserva_Anuncio_FK FOREIGN KEY (Id_Anuncio) REFERENCES Anuncio (Id_Anuncio),
		CONSTRAINT Reserva_Situacao_Reserva_FK FOREIGN KEY (Id_Situacao_Reserva) REFERENCES Situacao_Reserva (Id_Situacao_Reserva)
		);
