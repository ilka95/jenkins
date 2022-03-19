pipeline {
  agent { label 'мастер' }
  stages {
    stage('Install MySQL') {
      sh 'git clone https://github.com/jenkinsci/database-mysql-plugin.git'
    }
    stage('Run query') {
      steps {
        sh(script:'''
          mysql --user rfamro --host mysql-rfam-public.ebi.ac.uk --port 4497 --database Rfam < query.sql;
        ''')
      }
    }
  }
}
