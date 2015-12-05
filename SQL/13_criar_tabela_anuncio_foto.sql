Create table Anuncio_Foto(
	Id_Anuncio NUMBER NULL,
	Id_Foto NUMBER NULL,

	CONSTRAINT Anuncio_Foto_PK PRIMARY KEY (Id_Anuncio, Id_Foto)
);