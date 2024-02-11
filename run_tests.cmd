@echo off

set JIRA_USERNAME=<your_jira_email>
set JIRA_PASSWORD=<your_jira_password>
set JIRA_URL=https://YOUR_USERNAME.atlassian.net/

call powershell -Command "(Get-Content src/main/resources/application.yml) -replace '@jira.username@', '%JIRA_USERNAME%' -replace '@jira.password@', '%JIRA_PASSWORD%' -replace '@jira.url@', '%JIRA_URL%' | Set-Content src/main/resources/application.yml"

call mvn clean verify -Pwindows -Dcucumber.filter.tags="@UI" -Djasypt.encryptor.password=${ENCRYPTION_PASSWORD} -Denvironment=firefox %*
call mvn serenity:aggregate

call powershell -Command "(Get-Content src/main/resources/application.yml) -replace '%JIRA_USERNAME%', '@jira.username@' -replace '%JIRA_PASSWORD%', '@jira.password@' -replace '%JIRA_URL%', '@jira.url@' | Set-Content src/main/resources/application.yml"

set JIRA_USERNAME=
set JIRA_PASSWORD=
set JIRA_URL=