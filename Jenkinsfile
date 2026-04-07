pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Suhani0903/SeleniumGridProject.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Report') {
            steps {
                publishHTML([
                    reportName: 'Extent Report',
                    reportDir: 'target',                 // dir that contains the HTML file
                    reportFiles: 'ExtentReport.html'     
                ])
            }
        }
    }
}
