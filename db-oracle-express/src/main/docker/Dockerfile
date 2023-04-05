# base image
FROM container-registry.oracle.com/database/express:21.3.0-xe as base

ENV ORACLE_PASSWORD="Password"
# ORACLE_PASSWORD
# APP_USER
# APP_USER_PASSWORD

# step 2 - copy my local sql files to the container
#COPY setup/* /docker-entrypoint-initdb.d/

# step 3 - copy local start scripts files to the container
# COPY startup/* /docker-entrypoint-initdb.d/

# step 4 - run the base image
# USER oracle
# WORKDIR ${ORACLE_BASE}
# ENTRYPOINT ["container-entrypoint.sh"]

EXPOSE 1521
EXPOSE 5500

# See https://github.com/smallinsky/infra/blob/c1f86189e05ae36529e1266a1088a1df5b326bb5/oracle/Dockerfile
#COPY --chmod=777 *.sh /opt/oracle/
COPY setup/* /docker-entrypoint-initdb.d/setup
COPY startup/* /opt/oracle/scripts/startup/
#COPY --chmod=777 certs/ /certs/
ENTRYPOINT ["/opt/oracle/runOracle.sh"]