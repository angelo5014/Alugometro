Alter table Anuncio_Foto Add Id_Anuncio_Foto NUMBER NOT NULL;

Alter table Anuncio_Foto Drop CONSTRAINT Anuncio_Foto_PK;

Alter table Anuncio_Foto Add CONSTRAINT Anuncio_Foto_PK PRIMARY KEY (Id_Anuncio_Foto);

Alter table Anuncio_Foto Drop Column Id_Anuncio;
Alter table Anuncio_Foto Drop Column Id_Foto;

Alter table Anuncio_Foto Add Id_Anuncio NUMBER NOT NULL;
Alter table Anuncio_Foto Add Id_Foto NUMBER NOT NULL;

--RODAR SCRIPT 1 NOVAMENTE