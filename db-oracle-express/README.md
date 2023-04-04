# db oracle express

## Command Line

docker run -d --name XEDB container-registry.oracle.com/database/express:21.3.0-xe

### Docker Local Access

$ docker exec -it <oracle-db> sqlplus / as sysdba
$ docker exec -it <oracle-db> sqlplus sys/<your_password>@XE as sysdba
$ docker exec -it <oracle-db> sqlplus system/<your_password>@XE
$ docker exec -it <oracle-db> sqlplus pdbadmin/<your_password>@XEPDB1

### SQL Plus Access

# To connect to the database at the CDB$ROOT level as sysdba:
$ sqlplus sys/<your password>@//localhost:1521/XE as sysdba

# To connect as non sysdba at the CDB$ROOT level:
$ sqlplus system/<your password>@//localhost:1521/XE

# To connect to the default Pluggable Database (PDB) within the XE Database:
$ sqlplus pdbadmin/<your password>@//localhost:1521/XEPDB1

### OEM Express

To access OEM Express, start your browser, and enter the OEM URL: https://localhost:5500/em/


## References

- https://container-registry.oracle.com/ords/f?p=113:4:1327764185032:::4:P4_REPOSITORY,AI_REPOSITORY,AI_REPOSITORY_NAME,P4_REPOSITORY_NAME,P4_EULA_ID,P4_BUSINESS_AREA_ID:803,803,Oracle%20Database%20Express%20Edition,Oracle%20Database%20Express%20Edition,1,0&cs=3ALlzk3dLo5_qFSQGvCJdCZqL_QnQ9P2o4geyKlrhmVnIj2-GUicmeBsft57yd5qyyl3aVfQ7yvFcb7pD-emdIg
- https://docs.oracle.com/database/121/CNCPT/cdblogic.htm#CNCPT89304
- https://blog.devgenius.io/running-oracle-database-in-docker-containers-661b6f6e1d71