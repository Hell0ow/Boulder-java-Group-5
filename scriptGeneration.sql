#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: MAP
#------------------------------------------------------------

CREATE TABLE MAP(
        ID_map   int (11) Auto_increment  NOT NULL ,
        Name_map Text NOT NULL ,
        Xmin_map Int NOT NULL ,
        Xmax_map Int NOT NULL ,
        Ymax_map Int NOT NULL ,
        Ymin_map Int NOT NULL ,
        PRIMARY KEY (ID_map )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: BLOCK
#------------------------------------------------------------

CREATE TABLE BLOCK(
        ID_Block     int (11) Auto_increment  NOT NULL ,
        Name_block   Text NOT NULL ,
        Folder_block Text NOT NULL ,
        PRIMARY KEY (ID_Block )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: PLAYER
#------------------------------------------------------------

CREATE TABLE PLAYER(
        ID_player   int (11) Auto_increment  NOT NULL ,
        Name_player Text NOT NULL ,
        PRIMARY KEY (ID_player )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Compose
#------------------------------------------------------------

CREATE TABLE Compose(
        X_comp   Int NOT NULL ,
        Y_comp   Int NOT NULL ,
        ID_map   Int NOT NULL ,
        ID_Block Int NOT NULL ,
        PRIMARY KEY (ID_map ,ID_Block )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: play
#------------------------------------------------------------

CREATE TABLE play(
        score_play Int NOT NULL ,
        ID_map     Int NOT NULL ,
        ID_player  Int NOT NULL ,
        PRIMARY KEY (ID_map ,ID_player )
)ENGINE=InnoDB;

ALTER TABLE Compose ADD CONSTRAINT FK_Compose_ID_map FOREIGN KEY (ID_map) REFERENCES MAP(ID_map);
ALTER TABLE Compose ADD CONSTRAINT FK_Compose_ID_Block FOREIGN KEY (ID_Block) REFERENCES BLOCK(ID_Block);
ALTER TABLE play ADD CONSTRAINT FK_play_ID_map FOREIGN KEY (ID_map) REFERENCES MAP(ID_map);
ALTER TABLE play ADD CONSTRAINT FK_play_ID_player FOREIGN KEY (ID_player) REFERENCES PLAYER(ID_player);
