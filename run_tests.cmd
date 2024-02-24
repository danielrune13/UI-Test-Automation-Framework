call mvn clean verify -Pwindows -Dcucumber.filter.tags="@UI" -Djasypt.encryptor.password=${ENCRYPTION_PASSWORD} -Denvironment=firefox %*
call mvn serenity:aggregate