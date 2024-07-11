pipeline {
    agent any

     tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Clona o repositório do GitHub
                git branch: 'main', url:'https://github.com/GDCCosta/INF335-Trabalho05.1.git'
            }
        }
        
        stage('Build') {
            steps {
                // Compilação do projeto usando Maven
                sh 'mvn -Dmaven.test.failure.ignore=true clean package'
            }
        }

        stage('Run Test') {
            steps {
                // Execução dos testes JUnit
                sh 'mvn test'
                
                // Arquivo JUnit XML para relatório de testes
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
    }

    post {
        always {
            // Sempre execute este passo, independentemente do resultado
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts 'target/*.jar'
        }

        success {
            // Ações a serem tomadas se o Pipeline for bem-sucedido
            echo 'Pipeline bem-sucedido!'
        }

        failure {
            // Ações a serem tomadas se o Pipeline falhar
            echo 'Pipeline falhou :('
        }
    }
}
