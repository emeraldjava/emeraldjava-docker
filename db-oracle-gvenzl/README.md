# db-oracle-grenzl

Extend 'gvenzl/oci-oracle-xe' as part of a custom Docker image.

See https://hub.docker.com/r/gvenzl/oracle-xe


## Run

#!/bin/bash
docker rm my-oracle-xe-21c:latest
docker build -t my-oracle-xe-21c:latest ./src/main/docker/Dockerfile
docker run -d my-oracle-xe-21c:latest
