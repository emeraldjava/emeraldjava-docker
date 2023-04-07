# base image
FROM gvenzl/oracle-xe:latest as base

ENV ORACLE_PASSWORD=Password
ENV ORACLE_DATABASE=MYDB
ENV APP_USER=myuser
ENV APP_USER_PASSWORD=mypassword

# step 2 - copy my local sql files to the container
COPY ./initdb/* /docker-entrypoint-initdb.d/

# step 3 - copy local start scripts files to the container
COPY ./startdb/* /docker-entrypoint-initdb.d/

# step 4 - run the base image
USER oracle
WORKDIR ${ORACLE_BASE}
ENTRYPOINT ["container-entrypoint.sh"]