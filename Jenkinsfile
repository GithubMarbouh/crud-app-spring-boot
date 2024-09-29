node {
    def registry = 'docker.io/marbouh/crud-app'
    def image = 'jenkins-slave'
    def tag = 'latest'
    def registryCredential = 'jtoken'
    def mavenHome = 'C:\\apach\\apache-maven-3.9.7\\bin'

    stage('Clone repository') {
        bat 'git config --global http.postBuffer 524288000'
        bat 'git config --global http.maxRequestBuffer 100M'
        git branch: 'main', url: 'https://github.com/GithubMarbouh/crud-app-spring-boot.git'
    }
    stage('Build application') {
        withEnv(["PATH+MAVEN=${mavenHome}"]) {
            bat 'mvn -DskipTests=true clean install'
        }
    }
    stage('Build image') {
        bat "docker build -f Dockerfile -t ${registry}:${tag} ."
    }
    stage('Push image') {
        withCredentials([usernamePassword(credentialsId: registryCredential, usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
            bat "docker login -u ${DOCKERHUB_USERNAME} -p ${DOCKERHUB_PASSWORD}"
            bat "docker push ${registry}:${tag}"
        }
    }
}