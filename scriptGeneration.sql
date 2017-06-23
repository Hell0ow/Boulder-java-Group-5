#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: MAP
#------------------------------------------------------------

CREATE TABLE MAP(
        ID_map    int (11) Auto_increment  NOT NULL ,
        Name_map  Text NOT NULL ,
        Xmin_map  Int NOT NULL ,
        Xmax_map  Int NOT NULL ,
        Ymin_map  Int NOT NULL ,
        Ymax_map  Int NOT NULL ,
        nbDiamond Int ,
        mapTime   Int ,
        PRIMARY KEY (ID_map )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: BLOCK
#------------------------------------------------------------

CREATE TABLE BLOCK(
        ID_Block     int (11) Auto_increment  NOT NULL ,
        X_block      Int NOT NULL ,
        Y_block      Int NOT NULL ,
        ID_map       Int NOT NULL ,
        ID_typeBlock Int ,
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
# Table: ENTITY
#------------------------------------------------------------

CREATE TABLE ENTITY(
        ID_Entity     int (11) Auto_increment  NOT NULL ,
        X_entity      Int NOT NULL ,
        Y_entity      Int NOT NULL ,
        ID_map        Int NOT NULL ,
        ID_typeEntity Int NOT NULL ,
        PRIMARY KEY (ID_Entity )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TYPEblock
#------------------------------------------------------------

CREATE TABLE TYPEblock(
        ID_typeBlock int (11) Auto_increment  NOT NULL ,
        Name_block   Text NOT NULL ,
        Folder_block Text NOT NULL ,
        PRIMARY KEY (ID_typeBlock )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TYPEentity
#------------------------------------------------------------

CREATE TABLE TYPEentity(
        ID_typeEntity int (11) Auto_increment  NOT NULL ,
        Name_entity   Text NOT NULL ,
        Folder_entity Text NOT NULL ,
        DropType Text ,
        PRIMARY KEY (ID_typeEntity )
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

ALTER TABLE BLOCK ADD CONSTRAINT FK_BLOCK_ID_map FOREIGN KEY (ID_map) REFERENCES MAP(ID_map);
ALTER TABLE BLOCK ADD CONSTRAINT FK_BLOCK_ID_typeBlock FOREIGN KEY (ID_typeBlock) REFERENCES TYPEblock(ID_typeBlock);
ALTER TABLE ENTITY ADD CONSTRAINT FK_ENTITY_ID_map FOREIGN KEY (ID_map) REFERENCES MAP(ID_map);
ALTER TABLE ENTITY ADD CONSTRAINT FK_ENTITY_ID_typeEntity FOREIGN KEY (ID_typeEntity) REFERENCES TYPEentity(ID_typeEntity);
ALTER TABLE play ADD CONSTRAINT FK_play_ID_map FOREIGN KEY (ID_map) REFERENCES MAP(ID_map);
ALTER TABLE play ADD CONSTRAINT FK_play_ID_player FOREIGN KEY (ID_player) REFERENCES PLAYER(ID_player);
