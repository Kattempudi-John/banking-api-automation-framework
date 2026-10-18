
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
    }
}
