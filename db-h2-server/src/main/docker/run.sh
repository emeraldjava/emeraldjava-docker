#!/usr/bin/env bash

# clean
echo 'stop'
docker container stop h2
echo 'remove'
docker rm -v h2
#docker container rm h2

# https://github.com/oscarfonts/docker-h2/blob/master/2.1.210/run.sh
echo 'build'
docker build --force-rm=true --no-cache=true -t=h2 .

# run
echo 'run'
# -v /Users/emeraldjava/github/emeraldjava-docker/db-h2-oscar/src/main/docker/h2-data:/opt/h2-data
docker run -d -p 1521:1521 -p 81:81 --name=h2 h2
#docker logs -f h2 2>&1
#xdg-open http://localhost:81/

