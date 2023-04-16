# openjdk:11 image built on Debian GNU/Linux 11 (bullseye)
FROM openjdk:11

# A merge of:
#  https://github.com/zhilvis/docker-h2
#  https://github.com/zilvinasu/h2-dockerfile

LABEL org.opencontainers.image.authors="https://github.com/oscarfonts/docker-h2/graphs/contributors"

ARG DBNAME=myh2db
ENV DBNAME=${DBNAME}
ARG H2_VERSION=2.1.214
ARG DATA_DIR=/opt/h2-data
ENV DATA_DIR=${DATA_DIR}

# install h2 jar
ENV DOWNLOAD_URL https://repo1.maven.org/maven2/com/h2database/h2/${H2_VERSION}/h2-${H2_VERSION}.jar
RUN curl ${DOWNLOAD_URL} -o h2.jar

#ENV DOWNLOAD https://github.com/h2database/h2database/releases/download/version-2.1.214/h2-2022-06-13.zip
#ENV DATA_DIR /opt/h2-data
#ENV H2DATA /h2-data

RUN mkdir -p ${DATA_DIR}
VOLUME ${DATA_DIR}
#WORKDIR ${DATA_DIR}

#    && curl -L ${DOWNLOAD} -o h2.zip \
#    && unzip h2.zip -d /opt/ \
#    && rm h2.zip

EXPOSE 81 1521

#WORKDIR /opt/h2-data


#EXPOSE 8082 9092

# step 2 - copy my local sql files to the container
COPY ./setup/* /docker-entrypoint-initdb.d/

# copy the script
COPY docker-entrypoint.sh /usr/local/bin/
ENTRYPOINT ["docker-entrypoint.sh"]

#COPY h2cli.sh h2cli
#RUN chmod a+rx h2cli && mv h2cli /opt/h2/bin
#ENV PATH="${PATH}:/opt/h2/bin"

CMD java -cp h2.jar org.h2.tools.Server \
    -web -webAllowOthers -webPort 81 \
    -tcp -tcpAllowOthers -tcpPort 1521 \
    -baseDir ${DATA_DIR} ${H2_OPTIONS}