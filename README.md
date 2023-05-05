# Cadastro Cliente Frontend


##### Script SQL


	CREATE TABLE heroku_27ccf380157d58e.Cliente (
		id INT auto_increment NOT NULL
		nome varchar(100) NOT NULL
		tipo varchar(100) NOT NULL
		cpf_cnpj varchar(100) NOT NULL
		rg_ie varchar(100) NOT NULL
		data_cadastro DATETIME NULL
		ativo BIT NULL
		telefone varchar(100) null
		primary key (id)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;