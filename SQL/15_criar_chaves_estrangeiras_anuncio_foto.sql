Alter table Anuncio_Foto
	Add (
		CONSTRAINT Anuncio_Foto_Anuncio_FK FOREIGN KEY (Id_Anuncio) REFERENCES Anuncio (Id_Anuncio),
		CONSTRAINT Anuncio_Foto_Foto_FK FOREIGN KEY (Id_Foto) REFERENCES Foto (Id_Foto)
		);