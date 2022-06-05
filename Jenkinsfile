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
    stage('Push Docker Image'){
    	withCredentials([string(credentialsId: 'docker-pass', variable: 'dockerhubpass')]) {
    		sh "docker login -u rishabhnitb -p ${dockerhubpass}"
		}
        sh 'docker push rishabhnitb/star-wars:1.0.0'
    }
    stage('Run Container on Dev Server'){
        sh 'docker run -p 8080:8080 rishabhnitb/star-wars:1.0.0'
    }
}