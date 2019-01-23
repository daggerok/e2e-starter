#!/usr/bin/env bash
# mvnw -Dgroups=!e2e
# mvnw -f docker\pom.xml -Pup
./mvnw release:clean \
       release:prepare \
       release:perform \
         --batch-mode \
         -DgenerateBackupPoms=false \
         -DskipTests -Dgroups=!e2e
         -Darguments="-DskipTests -Dgroups=!e2e"
