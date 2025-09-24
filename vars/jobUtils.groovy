import jenkins.model.Jenkins
import hudson.model.Job

class JobUtils implements Serializable {

    @NonCPS
    def listJobs() {
        return Jenkins.instance.getAllItems(Job.class).collect { it.fullName }
    }

    @NonCPS
    def getJobConfig(String jobName) {
        def job = Jenkins.instance.getItemByFullName(jobName, Job.class)
        if (job) {
            return job.getConfigFile().asString()   // returns the raw XML
        }
        return null
    }
}

def listJobs() {
    return new JobUtils().listJobs()
}

def getJobConfig(String jobName) {
    return new JobUtils().getJobConfig(jobName)
}