pipeline {
  agent any

  triggers { githubPush() }

  options {
    timestamps()
    disableConcurrentBuilds()
    ansiColor('xterm')
    skipDefaultCheckout(true)
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build + Tests + Verify') {
      steps {
        script {
          if (isUnix()) {
            sh '''
              mvn -B -ntp -f classflow/pom.xml clean verify
            '''
          } else {
            powershell '''
              mvn -B -ntp -f classflow/pom.xml clean verify
            '''
          }
        }
      }
      post {
        always {
          junit allowEmptyResults: true, testResults: 'classflow/target/surefire-reports/*.xml'
          archiveArtifacts artifacts: 'classflow/target/*.jar', fingerprint: true, allowEmptyArchive: true
        }
      }
    }
  }

  post {
    failure {
      echo "CI en échec: consulte les logs et les rapports de tests."
    }
  }
}
