pipeline {
    agent any

        tools {
            jdk 'JDK_17'
            maven 'Maven_3.10.0'
        }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'edge'], description: 'Browser')
        string(name: 'TAGS', defaultValue: '@smoke', description: 'Cucumber tags, e.g. @smoke or @regression')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/<your-username>/bdd-testng-framework.git'
            }
        }

        stage('Run Tests') {
            steps {
                // use 'sh' instead of 'bat' on Linux/Mac
                bat "mvn clean test -Dbrowser=${params.BROWSER} -Dheadless=true -Dcucumber.filter.tags=\"${params.TAGS}\""
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                reportDir: 'target/extent-reports',
                reportFiles: 'SparkReport.html',
                reportName: 'Extent Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: true
            ])
            archiveArtifacts artifacts: 'target/**/*.html', allowEmptyArchive: true
        }
    }
}