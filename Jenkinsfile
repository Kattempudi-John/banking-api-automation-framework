
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
    }
}
