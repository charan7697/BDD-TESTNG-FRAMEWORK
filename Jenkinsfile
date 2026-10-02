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

    post {
        always {
            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/extent-reports',
                reportFiles: 'SparkReport.html',
                reportName: 'Extent Report'
            ])

            archiveArtifacts(
                artifacts: 'target/extent-reports/**',
                allowEmptyArchive: true
            )
        }
    }
}