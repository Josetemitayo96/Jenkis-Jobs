
job('Nodejs dsl docker example'){
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
        dockerBuildAndPublish {
            repositoryName('tayo96/docker-node-app')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

