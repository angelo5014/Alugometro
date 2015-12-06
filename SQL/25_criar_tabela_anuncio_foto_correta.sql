Create table Anuncio_Foto(
	Id_Anuncio_Foto NUMBER NOT NULL,
	Id_Anuncio NUMBER NULL,
	Id_Foto NUMBER NULL,

	CONSTRAINT Anuncio_Foto_PK PRIMARY KEY (Id_Anuncio_Foto);
	CONSTRAINT Anuncio_Foto_Anuncio_FK FOREIGN KEY (Id_Anuncio) REFERENCES Anuncio (Id_Anuncio),
	CONSTRAINT Anuncio_Foto_Foto_FK FOREIGN KEY (Id_Foto) REFERENCES Foto (Id_Foto)
);