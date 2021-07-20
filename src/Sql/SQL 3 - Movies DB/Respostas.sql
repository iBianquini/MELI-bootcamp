-- 1 Explique o conceito de normalização e para que é usado.
	-- É um processo para eliminar inconsistências e também padronizar as tabelas do BD. Isso é feito por meio de algumas regras que visam proteger a integridade dos dados e também tornar a interpretação mais fácil. 

-- 2 Adicione um filme à tabela de filmes.
	INSERT INTO movies VALUES (22, null, null, 'Die Hard', 9.9,3,'2012-08-06', 148, 4)
-- 3 Adicione um gênero à tabela de gêneros.
	INSERT INTO genres VALUES (13, '2019-04-23 05:00:00', NULL, 'SitCom', 13, 1)
-- 4 Associe o filme do Ex 2. ao gênero criado no Ex. 3.
	UPDATE movies SET genre_id = 13 where Id = 22
-- 5 Modifique a tabela de atores para que pelo menos um ator adicione como favorito o filme adicionado no Ex. 2.
	UPDATE actors SET favorite_movie_id = 22 where Id = 36
-- 6 Crie uma cópia temporária da tabela de filmes.
	SELECT * INTO TEMP TABLE temp_movies FROM movies
	SELECT * FROM temp_movies
-- 7 Elimine desta tabela temporária todos os filmes que ganharam menos de 5 prêmios.
	DELETE FROM temp_movies WHERE awards < 5
-- 8 Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
	SELECT g.name, COUNT(m.id) as totalFilmes FROM genres g
	inner join movies m on CAST(m.genre_id AS Integer) = g.Id
	GROUP BY g.name
-- 9 Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
	SELECT a.first_name, a.last_name, m.title, m.awards FROM actors a
	inner join movies m on m.id = CAST (a.favorite_movie_id AS Integer)
	where m.awards > 3
-- 10 Use o plano de explicação para analisar as consultas nos Ex. 6 e 7.
-- 11 O que são os índices? Para que servem?
	-- São mecanismos que servem pra otimizar as consultas no BD. Eles oferecem atalhos, acessos mais diretos aos dados. Evitando assim que seja necessário realizar varreduras completas na base de dados.
-- 12 Crie um índice sobre o nome na tabela de filmes.
	CREATE INDEX movieName ON movies (title)
-- 13 Verifique se o índice foi criado corretamente.
	SELECT * FROM pg_indexes WHERE tablename = 'movies';

