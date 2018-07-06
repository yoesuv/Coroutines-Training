timestampedNode{
    stage ("Checkout") {
        checkout scm
        sh "chmod a+x ./gradlew"
        //gitLib = load "git_push_ssh.groovy"
    }

    stage ("Build") {
        if (env.ANDROID_HOME == null || env.ANDROID_HOME == "") error "ANDROID_HOME not defined"
        if (env.JAVA_HOME == null || env.JAVA_HOME == "") error "JAVA_HOME not defined"
    }
}