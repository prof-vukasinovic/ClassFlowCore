pipeline {
  agent any

  triggers {
    // Déclenchement via webhook GitHub (plugin GitHub requis côté Jenkins)
    githubPush()
  }

  options {
    timestamps()
    disableConcurrentBuilds()
    ansiColor('xterm')
  }

  environment {
    // Cache Maven dans le workspace (simple et efficace sur agents persistants)
    MVN = "mvn -B -ntp -Dmaven.repo.local=${WORKSPACE}/.m2/repository -f classflow/pom.xml"
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build + Tests + Verify') {
      steps {
        // verify = tests + vérifications Maven (ex: enforcer/checkstyle/jacoco si configurés)
        sh "${env.MVN} clean verify"
      }
      post {
        always {
          // Résultats JUnit (Surefire)
          junit allowEmptyResults: true, testResults: 'classflow/target/surefire-reports/*.xml'

          // Archive les jars produits (inclut jar normal + jar-with-dependencies si généré)
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
