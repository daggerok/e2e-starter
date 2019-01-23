@echo off
rem call mvnw release:rollback
call mvnw release:clean release:prepare release:perform --batch-mode -DgenerateBackupPoms=false -Darguments="-DskipTests"
