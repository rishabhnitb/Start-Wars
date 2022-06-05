node{
    stage('GIT checkout'){
        git 'https://github.com/rishabhnitb/Start-Wars.git'
    }
    stage('MVN package'){
        def mvnHome = tool name: 'maven-3', type: 'maven'
        def mvnCmd = "${mvnHome}/bin/mvn"
        sh "${mvnCmd} clean package"
    }
    stage('Build Docker Image'){
        sh 'docker build -t rishabhnitb/star-wars:1.0.0 .'
    }
}