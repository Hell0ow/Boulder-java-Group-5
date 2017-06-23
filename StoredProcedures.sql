#------------------------------------------------------------
#       Stored Procedures
#------------------------------------------------------------

#--- MAP GENERATOR ---#

DELIMITER |
CREATE PROCEDURE generatorCountMap()
BEGIN

SELECT COUNT(ID_map) FROM MAP;

END |
DELIMITER ;

#CALL generatorCountMap();

#--------------------#





#--- Controller ---#

DELIMITER |
CREATE PROCEDURE addPlayer(
	IN playerName text 
)
BEGIN

INSERT INTO PLAYER VALUES ('', playerName);

END |
DELIMITER ;

#CALL addPlayer('playerName');

#--------------------#





#--- Controller ---#

DELIMITER |
CREATE PROCEDURE initPlayer(
	IN playerName text 
)
BEGIN

SELECT ID_player FROM PLAYER WHERE Name_player = playerName;

END |
DELIMITER ;

#CALL initPlayer('playerName');

#--------------------#





#--- Controller ---#

DELIMITER |
CREATE PROCEDURE getBlockTexture()
BEGIN

SELECT ID_typeBlock FROM TYPEblock;

END |
DELIMITER ;

#CALL getBlockTexture();

#--------------------#





#--- Controller ---#

DELIMITER |
CREATE PROCEDURE getAllEntityName()
BEGIN

SELECT ID_typeEntity FROM TYPEentity;

END |
DELIMITER ;

#CALL getAllEntityName();

#--------------------#





#--- Controller ---#

DELIMITER |
CREATE PROCEDURE getBoundary(
	IN mapID int
)
BEGIN

SELECT Xmin_map, Xmax_map, Ymax_map, Ymin_map FROM MAP WHERE ID_map = mapID;

END |
DELIMITER ;

#CALL getBoundary('mapID');

#--------------------#





#--- Controller ---#

DELIMITER |
CREATE PROCEDURE getBlock(
	IN mapID int
)
BEGIN

SELECT X_block, Y_block, TYPEblock.Name_block FROM BLOCK INNER JOIN TYPEblock ON BLOCK.ID_typeBlock = TYPEblock.ID_typeBlock WHERE ID_map = mapID;

END |
DELIMITER ;

#CALL getBlock('mapID');

#--------------------#





#--- Controller ---#

DELIMITER |
CREATE PROCEDURE getEntity(
	IN mapID int
)
BEGIN

SELECT X_entity, Y_entity, TYPEentity.Name_entity FROM ENTITY INNER JOIN TYPEentity ON ENTITY.ID_typeEntity = TYPEentity.ID_typeEntity WHERE ID_map = mapID;

END |
DELIMITER ;

#CALL getEntity('mapID');

#--------------------#





#--- Controller ---#

DELIMITER |
CREATE PROCEDURE getMapID(
	IN mapName text
)
BEGIN

SELECT ID_map FROM MAP WHERE Name_map = mapName;

END |
DELIMITER ;

#CALL getMapID('mapName');

#--------------------#





#--- Controller ---#

DELIMITER |
CREATE PROCEDURE getAllMapName()
BEGIN

SELECT Name_map FROM MAP;

END |
DELIMITER ;

#CALL getAllMapName();

#--------------------#
