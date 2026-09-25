pipeline {
    agent any

    parameters {
        string(name: 'tags', defaultValue: '@Regression', description: 'Cucumber tags to execute (Eg. @Login)')
        choice(name: 'browser_environment', choices: ['chrome', 'firefox', 'edge'], description: 'Browser environment where tests will be executed')
        choice(name: 'application_environment', choices: ['test', 'preprod', 'dev'], description: 'Application environment to test')
    }

    stages {
        stage('Run Tests') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn clean verify -Dcucumber.filter.tags="${tags}" -Djasypt.encryptor.password=$ENCRYPTION_PASSWORD -Denvironment=${browser_environment} -Dspring.profiles.active=${application_environment}'
                    } else {
                        bat 'mvn clean verify -Dcucumber.filter.tags="%tags%" -Djasypt.encryptor.password=%ENCRYPTION_PASSWORD% -Denvironment=%browser_environment% -Dspring.profiles.active=%application_environment%'
                    }
                }
            }
        }
    }

    post {
        always {
            allure results: [[path: 'target/allure-results']]
        }
    }
}