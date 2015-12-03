------------Anuncio------------
Create Index IX_Anuncio_Cidade on Anuncio(Id_Cidade);
Create Index IX_Anuncio_Foto_Capa on Anuncio(Id_Foto_Capa);
Create Index IX_Anuncio_Situacao on Anuncio(Id_Situacao_Anuncio);
Create Index IX_Anuncio_Tipo_Acomodacao on Anuncio(Id_Tipo_Acomodacao);
Create Index IX_Anuncio_Tipo_Imovel on Anuncio(Id_Tipo_Imovel);
Create Index IX_Anuncio_Usuario on Anuncio(Id_Usuario);

------------País/Estado/Cidade------------

Create Index IX_Cidade_Estado on Cidade(Id_Estado);
Create Index IX_Estado_Federacao on Estado(Id_Federacao);

------------Fotos------------

Create Index IX_Foto_Anuncio on Foto(Id_Anuncio);

------------Reserva------------

Create Index IX_Reserva_Anuncio on Reserva(Id_Anuncio);
Create Index IX_Reserva_Situacao on Reserva(Id_Situacao_Reserva);
Create Index IX_Reserva_Usuario on Reserva(Id_Usuario);

------------Usuario------------

Create Index IX_Usuario_Situacao on Usuario(Id_Situacao_Usuario);
