import jenkins.model.Jenkins
import hudson.model.Job

class JobUtils implements Serializable {

    @NonCPS
    def listJobs() {
        return Jenkins.instance.getAllItems(Job.class).collect { it.fullName }
    }
}

def listJobs() {
    return new JobUtils().listJobs()
}