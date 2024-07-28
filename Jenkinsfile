pipeline {
    agent any

    environment {
        // Define any environment variables here
        JAR_NAME = "springboot-keycloak-admin-client-0.0.1-SNAPSHOT.jar"
        DEPLOY_DIR = "D:/Del/springboot"
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
                bat './mvnw -B -DskipTests clean package'
            }
        }

        stage('Deploy') {
            steps {
                // Copy the generated JAR to the deploy directory
                script {
                    def jarFile = findFiles(glob: 'target/*.jar')[0].path
                    bat "copy ${jarFile} ${DEPLOY_DIR}\\${JAR_NAME}"
                }
            }
        }

        stage('Run') {
            steps {
                // Run the Spring Boot application
                bat """
                    set JAR_PATH=${DEPLOY_DIR}\\${JAR_NAME}
                    start javaw -jar %JAR_PATH%
                """
            }
        }
    }

    post {
        always {
            // Clean up workspace
            cleanWs()
        }
    }
}