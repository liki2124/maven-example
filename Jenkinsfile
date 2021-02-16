pipeline{
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
    }
  }
  stages {
    stage('Maven-Clean'){
      steps{
        sh 'mvn clean'
      }
    }
    stage('Maven-Compile'){
      steps{
        sh 'mvn compile'
      }
    }
    stage('Maven_Test'){
      steps{
        sh 'mvn test'
      }
    }
    stage('Maven-Package'){
      steps{
        sh 'mvn package'
      }
    }
    node {
  stage('Clone the Git') {
    git 'https://github.com/liki2124/maven-example'
  }
  stage('SonarQube analysis') {
    def scannerHome = tool 'sonarqube';
    withSonarQubeEnv('sonarqube') {
      sh "${scannerHome}/bin/sonar-scanner 
    }
  }
}

  }
}
