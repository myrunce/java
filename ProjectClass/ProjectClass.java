public class ProjectClass{
    private String projectName;
    private String projectDesc;

    public ProjectClass(String name, String desc){
        projectName = name;
        projectDesc = desc;
    }

    public ProjectClass(){
    }

    public ProjectClass(String name){
        projectName = name;
    }

    public String elevatorPitch(){
        return projectName + " : " + projectDesc; 
    }
}