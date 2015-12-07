Create table Token(
	Id_Token NUMBER NOT NULL,
	Id_Usuario NUMBER NOT NULL,
	Token VARCHAR2(500) NOT NULL,

	CONSTRAINT Token_PK PRIMARY KEY (Id_Token),
	CONSTRAINT Token_Usuario_FK FOREIGN KEY (Id_Usuario) REFERENCES Usuario (Id_Usuario)
);

Create sequence SEQ_Token START WITH 1 INCREMENT BY 1;

Alter table Token Add Situacao_Token NUMBER NOT NULL;




ALTER TABLE Token
  Add CONSTRAINT Token_UK UNIQUE (Token);