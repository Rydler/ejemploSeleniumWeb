pipeline {
	agent any
	stages {
		stage('Clean') {
			steps {
				echo "Limpiar"
			sh "mvn clean"
			}
		}
		stage('Compile') {
			steps {
				echo "Limpiar y Compilar código"
				sh "mvn clean compile -e"
			}
		}
		stage('Test') {
			steps {
				echo "Ejecutar test de Selenium"
				sh "mvn test"
			}
		}
	}
}