pipeline {
    agent any

    tools {
        jdk 'JDK_17'
        maven 'Maven_3.10.0'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }
}