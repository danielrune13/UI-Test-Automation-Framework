pipeline {
    agent any

    parameters {
        string(name: 'tags', defaultValue: '@Regression', description: 'Cucumber tags to execute (Eg. @Login)')
        choice(name: 'browser_environment', choices: ['chrome', 'firefox', 'edge'])
        choice(name: 'application_environment', choices: ['test', 'preprod', 'dev'])
    }

    stages {
        stage('Run Tests') {
            steps {
                bat 'mvn clean verify -Dcucumber.filter.tags="%tags%" -Djasypt.encryptor.password=$ENCRYPTION_PASSWORD -Denvironment=%browser_environment% -Dspring.profiles.active=%application_environment%'
            }
        }
    }
}