#!/usr/bin/env bash
# ./mvnw release:rollback
./mvnw release:clean \
       release:prepare \
       release:perform \
         --batch-mode \
         -DgenerateBackupPoms=false \
         -DskipTests -Dgroups=!e2e
         -Darguments="-DskipTests -Dgroups=!e2e"
