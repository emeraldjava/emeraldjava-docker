# emeraldjava-docker

A set of docker images emeraldjava is experimenting with.

## docker-plugin

https://dmp.fabric8.io/

## Test Containers

https://www.atomicjar.com/2021/12/new-in-testcontainers-dec-2021/

## SQL logins

    sqlplus sys/Password@//localhost:1521/XE as sysdba
    sqlplus system/Password@//localhost:1521/XE
    sqlplus system/Password@//localhost:1521/XEPDB1
    sqlplus system/Password@//0.0.0.0:1521/XEPDB1


## Aliases for docker oracle db

    alias sqlp.sysdba='sqlplus sys/Password@//localhost:1521/XE as sysdba'
    alias sqlp.system='sqlplus system/Password@//localhost:1521/XE'
    alias sqlp.pdb='sqlplus system/Password@//localhost:1521/XEPDB1'
    alias sqlp.mydb='sqlplus myuser/mypassword@//localhost:1521/MYDB'