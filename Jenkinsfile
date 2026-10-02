pipeline {
    agent any

    tools {
        jdk 'JDK_17'
        maven 'Maven_3.10.0'
    }

    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Select browser'
        )

        string(
            name: 'TAGS',
            defaultValue: '@login',
            description: 'Cucumber tags, e.g. @login or @regression'
        )
    }

    stages {

        stage('Run Tests') {
            steps {
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

            archiveArtifacts(
                artifacts: 'target/**/*.html',
                allowEmptyArchive: true
            )
        }
    }
}