drop schema if exists catalogoiso16;
create schema catalogoiso16;
use catalogoiso16;

create table Cliente (

	CF					char(16) primary key,
    Nome 		   		varchar(30) not null,
    Cognome 	   		varchar(30) not null,
    Data_di_nascita		date not null,
    Telefono 			varchar(20) not null,
    Email				varchar(100) not null,
    UserName			varchar(30) not null,
    PW					varchar(30) not null

);

create table Indirizzo(

	Nazione				varchar(30) not null,
    Città				varchar(30) not null,
    Cap					int not null,
    Civico				int not null,
    Via					varchar(100) not null,
    Codice_Fiscale_Cliente char(16) not null,
    foreign key (Codice_Fiscale_Cliente) references Cliente(CF) on update cascade on delete cascade,
    primary key(Città,Codice_Fiscale_Cliente)

);

create table Metodo_di_pagamento(

	Codice					varchar(10) primary key,
    Tipo					varchar(15) not null,
    Numero_Carta			int,		
    CVC						int,
    Codice_Gifcard			varchar(10),
    Data_Scadenza			date

);

create table Ordine(

	ID 						int unsigned primary key auto_increment,
    Prezzo_tot				float not null,
    Data_ordine				date not null,
    Codice_Fiscale_Cliente	char(16) not null,
    Codice_Pagamento		varchar(10) not null,
    foreign key (Codice_Pagamento) references Metodo_di_pagamento(Codice) on update cascade on delete cascade,
    foreign key (Codice_Fiscale_Cliente) references Cliente(CF) on update cascade 

);

create table Amministratore(

	Username			varchar(30) primary key,
    PW					varchar(30) not null

);

create table Prodotto(

	Codice					varchar(10) primary key,
    prezzo					float not null,
    descrizzione			varchar(300) not null,
    Categoria				varchar(30) not null,
    Media_Valutazioni		float not null,
    Amministratore			varchar(30),
    foreign key (Amministratore) references Amministratore(Username) on update cascade on delete cascade

);

create table acquisto(

	Codice_sconto			varchar(10),
    ID_Ordine				int unsigned not null,
    Codice_Prodotto			varchar(10) not null,
    Quantità				int not null,
    foreign key	(ID_Ordine) references Ordine(ID) on update cascade,
    foreign key (Codice_Prodotto) references Prodotto(codice) on update cascade on delete cascade

);

create table recensione(

	Commento				varchar(300) not null,
    Valutazione				int,
    Codice_Prodotto			varchar(10),
    CF_cliente				char(16),
    foreign key 			(Codice_Prodotto) references Prodotto(codice) on update cascade on delete cascade,
    foreign key (CF_Cliente) references Cliente(CF) on update cascade on delete cascade

);
