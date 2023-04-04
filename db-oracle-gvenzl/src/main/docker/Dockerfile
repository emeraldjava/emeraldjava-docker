# base image
FROM gvenzl/oracle-xe:21-slim as base

ENV ORACLE_PASSWORD="SystemPw!"
# ORACLE_PASSWORD
# APP_USER
# APP_USER_PASSWORD

# step 2 - copy my local sql files to the container
COPY ./initdb/* /container-entrypoint-initdb.d/

# step 3 - copy local start scripts files to the container
COPY ./startdb/* /container-entrypoint-startdb.d/

# step 4 - run the base image
USER oracle
WORKDIR ${ORACLE_BASE}
ENTRYPOINT ["container-entrypoint.sh"]