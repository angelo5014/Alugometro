INSERT INTO Anuncio (
                    Id_Anuncio,
                    Id_Usuario,
                    Id_Tipo_Imovel,
                    Id_Tipo_Acomodacao,
                    Numero_Pessoas,
                    Id_Cidade,
                    Data_Inicio,
                    Data_Fim,
                    Diaria,
                    Descricao_Capa,
                    Descricao_Detalhada,
                    Id_Foto_Capa,
                    Id_Situacao_Anuncio
                    )
VALUES (SEQ_Anuncio.nextval, 1, 1, 1, 1, 1, SYSDATE, SYSDATE, 123.45, 'Descrição detalhada.', 'Descrição detalhada', 1, 1);

commit;