pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clona o repositório do GitHub
                git 'https://github.com/GDCCosta/INF335-Trabalho05.1.git'
            }
        }
        
        stage('Build') {
            steps {
                // Compilação do projeto usando Maven
                sh 'mvn clean package'
            }
        }

        stage('Run Test') {
            steps {
                // Execução dos testes JUnit
                sh 'mvn test'
                
                // Arquivo JUnit XML para relatório de testes
                junit 'target/surefire-reports/TEST-*.xml'
            }
        }
    }

    post {
        always {
            // Sempre execute este passo, independentemente do resultado
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            junit 'target/surefire-reports/TEST-*.xml'
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
