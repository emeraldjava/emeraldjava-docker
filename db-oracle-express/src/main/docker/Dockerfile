# base image
FROM container-registry.oracle.com/database/express:21.3.0-xe as base

ENV ORACLE_PASSWORD="Password"
# ORACLE_PASSWORD
# APP_USER
# APP_USER_PASSWORD

# step 2 - copy my local sql files to the container
COPY setup/* /docker-entrypoint-initdb.d/

# step 3 - copy local start scripts files to the container
# COPY startup/* /docker-entrypoint-initdb.d/

# step 4 - run the base image
# USER oracle
# WORKDIR ${ORACLE_BASE}
# ENTRYPOINT ["container-entrypoint.sh"]