pipeline {
  agent { label 'master'}
  stages {
    stage('query') {
      steps {
        sh(script:'''
          mysql --user rfamro --host mysql-rfam-public.ebi.ac.uk --port 4497 --database Rfam < query.sql;
        ''')
      }
    }
  }
}
