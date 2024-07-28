pipeline {
    agent any

    environment {
        // Define any environment variables here
        JAR_NAME = "springboot-keycloak-admin-client-0.0.1-SNAPSHOT.jar"
        DEPLOY_DIR = "D:\\Del\\springboot"
    }
    
	options {
	  //Keep console logs of 1 build only
	  buildDiscarder(logRotator(numToKeepStr: '1', artifactNumToKeepStr: '5'))
	}
	
	parameters {
        booleanParam(name: 'docker_run', defaultValue: true, description: 'Set to true to run with docker')
    }

    stages {
        stage('Checkout') {
            steps {
                // Clone the GitHub repository
                git 'https://github.com/darksidemember/springboot-keycloak-admin-client.git'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                // Copy the generated JAR to the deploy directory
                script {
                    bat "copy target\\${JAR_NAME} ${DEPLOY_DIR}\\${JAR_NAME}"
                }
            }
        }

        stage('Run JAR file') {
        	when { expression { params.docker_run != true } }
            steps {
               // Run the Spring Boot application as a jar file
               bat """
                    set JAR_PATH=${DEPLOY_DIR}\\${JAR_NAME}
                    java -jar %JAR_PATH%
                """
            }
        }

        stage('Run with docker') {
        	when { expression { params.docker_run == true } }
            steps {
               // Run the Spring Boot application with docker
               bat """
               		DIR
                    docker build --tag=springboot-keycloak-admin-client:latest .
                    docker run -p8090:8090 springboot-keycloak-admin-client:latest
                """
            }
        }
    }
}