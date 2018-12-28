#!/bin/bash
cd target
ftp -p -niv <<- EOF
open 172.21.205.30
user admin dongge
bin
cd docker-war
delete jia_process_middleware.jar
put jia_process_middleware.jar
bye
EOF
echo "put ftp server successfull okok"
