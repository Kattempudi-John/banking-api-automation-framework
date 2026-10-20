
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
                withEnv([
                    'JAVA_HOME=C:\\Program Files\\Java\\jdk-17',
                    'MAVEN_HOME=C:\\Users\\katte\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9',
                    'PATH+JAVA=C:\\Program Files\\Java\\jdk-17\\bin',
                    'PATH+MAVEN=C:\\Users\\katte\\Downloads\\apache-maven-3.9.9-bin\\apache-maven-3.9.9\\bin',
                    'PATH+SYSTEM32=C:\\Windows\\System32'
                ]) {
                    bat 'echo JAVA_HOME=%JAVA_HOME%'
                    bat 'where.exe java'
                    bat 'java -version'
                    bat 'where.exe mvn'
                    bat 'mvn -version'
                }
            }
        }

        stage('Verify Docker from Jenkins') {
            steps {
                withEnv([
                    'PATH+SYSTEM32=C:\\Windows\\System32',
                    'PATH+DOCKER=C:\\Users\\katte\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin'
                ]) {
                    bat 'echo Verifying Jenkins Windows account'
                    bat 'C:\\Windows\\System32\\whoami.exe'

                    bat 'echo Checking Docker executable'
                    bat 'where.exe docker'

                    bat 'echo Checking Docker version'
                    bat 'docker --version'

                    bat 'echo Checking Docker Compose'
                    bat 'docker compose version'

                    bat 'echo Checking Docker engine'
                    bat 'docker info'

                    bat 'echo Checking running containers'
                    bat 'docker ps'
                }
            }
        }
    }
}
