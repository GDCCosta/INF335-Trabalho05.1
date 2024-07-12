-app/pipeline {
    agent any

    tools {
        // Instala a versão do Maven configurada como "M3" e a adiciona ao path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Clona o repositório do GitHub especificado
                git branch: 'main', url: 'https://github.com/GDCCosta/INF335-Trabalho05.1.git'
                
                // Execute o Maven em um agente Unix.
                // Executa o Maven para limpar o projeto, compilar e empacotar.
                // O parâmetro -Dmaven.test.failure.ignore=true indica para o Maven ignorar falhas nos testes unitários e continuar a execução.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // Publica os resultados dos testes JUnit localizados nos arquivos XML dentro do diretório
                junit '**/target/surefire-reports/TEST-*.xml'
                // Arquiva os artefatos gerados (arquivos .jar) que estão no diretório
                archiveArtifacts 'target/*.jar'
            }
        }
    }
}

