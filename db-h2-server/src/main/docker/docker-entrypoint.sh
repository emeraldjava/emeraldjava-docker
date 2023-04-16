#!/usr/bin/env bash
set -e

RUNSCRIPT="java -cp h2.jar org.h2.tools.RunScript"

runSql() {
  filename=$(basename "$1")
  #echo "filename $filename"
  url="jdbc:h2:$DATA_DIR/${DB_NAME}"
  echo "using url $url"
  #echo "RUNSCRIPT $RUNSCRIPT"
  $RUNSCRIPT -script "$1" -url "$url"
}

mkdir -p "$DATA_DIR"
if [ ! -f "$DATA_DIR/.initdb.completed" ]; then
  echo
  for f in /docker-entrypoint-initdb.d/*; do
    case "$f" in
      *.sh)     echo "$0: running $f"; . "$f" ;;
      *.sql)    echo "$0: running $f"; runSql "$f" ;;
      *)        echo "$0: ignoring $f" ;;
    esac
    echo
  done
  touch "$DATA_DIR/.initdb.completed"
fi

exec "$@"