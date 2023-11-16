pipeline {
    agent any
    environment {
        Push_Docker = false
        Nexus=true

    }
    stages {
        stage('Git') {
            steps {
                git branch: 'main',
                url:'https://github.com/asmabenboubaker/Devops_Project.git'

            }

        }
        stage('build') {
            steps {
               sh 'mvn clean install'
               sh 'mvn -v'

            }

        }


          stage('Sonarqube') {
            steps {
               sh 'mvn sonar:sonar -Dsonar.login=squ_5dd3021941c4d2feb5cbe5937b6b495aa290b8d0'

            }

        }
         stage('Test') {
            steps {
                // Run JUnit tests
                sh 'mvn test'
            }
        }

         stage('Artifact construction') {
            steps {

                sh 'mvn package -DskipTests'
            }
        }

         stage('Nexus') {
               when {
                expression { return env.Nexus == true }
            }
            steps {

                sh 'mvn deploy'
            }
        }
     stage('build docker image') {
     steps {
        script {

            sh 'mvn clean install'
            sh 'docker build -t asma251/devops_project:2.1 .'
        }
    }
}
    stage('push image to hub') {

     steps {
        script {
            // Login to Docker Hub
            sh 'docker login -u asma251 -p got7leeminho'

            sh 'docker push  asma251/devops_project:2.1'
        }
    }
  }
  stage('docker compose') {
     steps {
        script {
            //Remove the volumes associated with the MySQL container
            sh 'docker-compose down -v'
            sh 'docker-compose up -d'
            sh 'docker-compose ps'
            sh 'docker-compose logs mysqldb'
        }
    }
}

    }
}
