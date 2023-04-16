# openjdk:11 image built on Debian GNU/Linux 11 (bullseye)
FROM openjdk:11

# A merge of:
#  https://github.com/zhilvis/docker-h2
#  https://github.com/zilvinasu/h2-dockerfile

LABEL org.opencontainers.image.authors="https://github.com/oscarfonts/docker-h2/graphs/contributors"

# DB_NAME and DATA_DIR
ARG DB_NAME=myh2db
ENV DB_NAME=${DB_NAME}
ARG DATA_DIR=/opt/h2-data
ENV DATA_DIR=${DATA_DIR}

# install the latest h2 jar
ARG H2_VERSION=2.1.214
ENV DOWNLOAD_URL https://repo1.maven.org/maven2/com/h2database/h2/${H2_VERSION}/h2-${H2_VERSION}.jar
RUN curl ${DOWNLOAD_URL} -o h2.jar

RUN mkdir -p ${DATA_DIR}
VOLUME ${DATA_DIR}

# copy local sql files and run script to the container
COPY ./setup/* /docker-entrypoint-initdb.d/
COPY docker-entrypoint.sh /usr/local/bin/
ENTRYPOINT ["docker-entrypoint.sh"]

# ports as ARG, ENV and EXPOSE
ARG WEB_PORT=81
ENV WEB_PORT=${WEB_PORT}
ARG TCP_PORT=1521
ENV TCP_PORT=${TCP_PORT}
EXPOSE ${WEB_PORT} ${TCP_PORT}

# the cli command to start the TCP server
CMD java -cp h2.jar org.h2.tools.Server \
    -web -webAllowOthers -webPort ${WEB_PORT} \
    -tcp -tcpAllowOthers -tcpPort ${TCP_PORT} \
    -baseDir ${DATA_DIR} ${H2_OPTIONS}