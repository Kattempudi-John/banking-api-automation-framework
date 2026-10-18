
pipeline {
    agent any

    stages {
        stage('Verify Repository Checkout') {
            steps {
                bat 'echo Jenkins successfully started the pipeline'
                bat 'git rev-parse --show-toplevel'
                bat 'dir'
            }
        }

        stage('Check Java and Maven') {
                    steps {
                        bat 'echo PATH=%PATH%'
                        bat 'echo JAVA_HOME=%JAVA_HOME%'
                        bat 'echo MAVEN_HOME=%MAVEN_HOME%'
                        bat 'dir C:\\Windows\\System32\\where.exe'
                        bat 'java -version'
                        bat 'mvn -version'
                    }
                }
    }
}
