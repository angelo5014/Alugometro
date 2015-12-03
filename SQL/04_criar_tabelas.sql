
--------Usuario---------

Create table Usuario(
  Id_Usuario NUMBER NOT NULL,
  Id_User NUMBER NOT NULL,
  Email VARCHAR2(250) NOT NULL,
  Situacao NUMBER NOT NULL,
  
  CONSTRAINT Usuario_PK PRIMARY KEY (Id_Usuario)
  );


Create table Situacao_Usuario(
  Id_Situacao_Usuario NUMBER NOT NULL,
  Descricao VARCHAR2(7)  NOT NULL,
  
  CONSTRAINT Situacao_Usuario_PK PRIMARY KEY (Id_Situacao_Usuario)
  );


--------Cidade---------

Create table Cidade(
  Id_Cidade NUMBER NOT NULL,
  Nome VARCHAR2(300) NOT NULL,
  Id_Estado NUMBER NOT NULL,
  
  CONSTRAINT Cidade_PK PRIMARY KEY (Id_Cidade)
  );

--------Estado---------

Create table Estado(
  Id_Estado NUMBER NOT NULL,
  Nome VARCHAR2(300) NOT NULL,
  UF VARCHAR2(2) NOT NULL,
  Id_Federacao NUMBER NOT NULL,
  
  CONSTRAINT Estado_PK PRIMARY KEY (Id_Estado)
  );

--------Federação---------

Create table Federacao(
  Id_Federacao NUMBER NOT NULL,
  Nome VARCHAR2(300) NOT NULL,
  
  CONSTRAINT Federacao_PK PRIMARY KEY (Id_Federacao)
  );


--------Anúncio---------

Create table Anuncio(
	Id_Anuncio NUMBER NOT NULL,
	Id_Usuario NUMBER NOT NULL,
	Id_Tipo_Imovel NUMBER NOT NULL,
	Id_Tipo_Acomodacao NUMBER NOT NULL,
	Numero_Pessoas NUMBER NOT NULL,
	Id_Cidade NUMBER NOT NULL,
	Data_Inicio DATE NOT NULL,
	Data_Fim DATE NOT NULL,
	Diaria NUMBER(38,2),
	Descricao_Capa VARCHAR2(300) NOT NULL,
	Descricao_Detalhada VARCHAR2(1000) NOT NULL,
	Id_Foto_Capa NUMBER NOT NULL,
	Id_Situacao_Anuncio NUMBER NOT NULL,

	CONSTRAINT Anuncio_PK PRIMARY KEY (Id_Anuncio)
);


Create table Situacao_Anuncio(
	Id_Situacao_Anuncio NUMBER NOT NULL,
	Descricao VARCHAR2(12)  NOT NULL,

	CONSTRAINT Situacao_Anuncio_PK PRIMARY KEY (Id_Situacao_Anuncio)
);

--------Fotos---------

Create table Foto(
	Id_Foto NUMBER NOT NULL,
	Url VARCHAR2(300) NOT NULL,
	Id_Anuncio NUMBER NOT NULL,

	CONSTRAINT Foto_PK PRIMARY KEY (Id_Foto)
);

--------Tipo de imóvel---------

Create table Tipo_Imovel(
  Id_Tipo_Imovel NUMBER NOT NULL,
  Descricao VARCHAR2(50)  NOT NULL,
  
  CONSTRAINT Tipo_Imovel_PK PRIMARY KEY (Id_Tipo_Imovel)
  );

--------Tipo de acomodação---------

Create table Tipo_Acomodacao(
  Id_Tipo_Acomodacao NUMBER NOT NULL,
  Descricao VARCHAR2(50)  NOT NULL,
  
  CONSTRAINT Tipo_Acomodacao_PK PRIMARY KEY (Id_Tipo_Acomodacao)
  );


--------Reserva---------

Create table Reserva(
	Id_Reserva NUMBER NOT NULL,
	Id_Usuario NUMBER NOT NULL,
	Id_Anuncio NUMBER NOT NULL,
	Data_Inicio  DATE NOT NULL,
	Data_Fim DATE NOT NULL,
	Valor_Diaria NUMBER(38,2) NOT NULL,
	Valor_Total NUMBER(38,2) NOT NULL,
	Id_Situacao_Reserva NUMBER NOT NULL,

	 CONSTRAINT Reserva_PK PRIMARY KEY (Id_Reserva)
);

Create table Situacao_Reserva(
	Id_Situacao_Reserva NUMBER NOT NULL,
	Descricao VARCHAR2(11) NOT NULL,

	CONSTRAINT Situacao_Reserva_PK PRIMARY KEY (Id_Situacao_Reserva)
);