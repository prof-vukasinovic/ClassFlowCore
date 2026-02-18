pipeline {
  agent any

  triggers { githubPush() }

  options {
    timestamps()
    disableConcurrentBuilds()
    ansiColor('xterm')
  }

  environment {
    // Force cmd.exe pour les étapes bat()
    COMSPEC = 'C:\\Windows\\System32\\cmd.exe'

    // Maven (projet dans classflow/)
    MVN = "mvn -B -ntp -Dmaven.repo.local=%WORKSPACE%\\.m2\\repository -f classflow\\pom.xml"
  }

  stages {
    stage('Diag') {
      steps {
        bat 'echo COMSPEC=%COMSPEC%'
        bat 'where cmd'
        bat 'where mvn || echo "mvn introuvable (Maven pas dans PATH)"'
        bat 'mvn -v || echo "Impossible d\'executer mvn"'
      }
    }

    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Build + Tests + Verify') {
      steps {
        bat "%MVN% clean verify"
      }
      post {
        always {
          junit allowEmptyResults: true, testResults: 'classflow\\target\\surefire-reports\\*.xml'
          archiveArtifacts artifacts: 'classflow\\target\\*.jar', fingerprint: true, allowEmptyArchive: true
        }
      }
    }
  }
}
