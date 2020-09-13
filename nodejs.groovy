job('Nodejs dsl example'){
    scm {
        git('https://github.com/Josetemitayo96/Jenkins-demo') { node ->
            node / gitConfigName('Jose Temitayo')
            node / gitConfigEmail('temitayojose@gmail.com')

        }
    }
    triggers{
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
}