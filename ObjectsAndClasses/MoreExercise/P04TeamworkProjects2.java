package ObjectsAndClasses.MoreExercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04TeamworkProjects2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countTeams = Integer.parseInt(scanner.nextLine());
        List<Project> projects = new ArrayList<>();

        for (int i = 0; i < countTeams; i++) {
            String[] input = scanner.nextLine().split("-");
            String creator = input[0];
            String projectName = input[1];

            Project haveCreator = projects.stream().filter(s->s.getCreator().equals(creator)).findFirst().orElse(null);
            Project haveProject = projects.stream().filter(s->s.getProjectName().equals(projectName)).findFirst().orElse(null);

            if(haveProject == null && haveCreator == null){
                Project singleProject = new Project(projectName, creator);
                projects.add(singleProject);
                System.out.printf("Team %s has been created by %s!%n", projectName, creator);
            }
            if(haveProject != null){
                System.out.printf("Team %s was already created!%n", projectName);
            }
            if(haveCreator != null){
                System.out.printf("%s cannot create another team!%n", creator);
            }

        }

        String input = scanner.nextLine();
        while (!input.equals("end of assignment")) {
            String[] userInfo = input.split("->");
            String username = userInfo[0];
            String teamName = userInfo[1];

            Project haveTeam = projects.stream().filter(s->s.getProjectName().equals(teamName)).findFirst().orElse(null);
            Project haveMember = projects.stream().filter(s->s.getMembers().contains(username) || s.getCreator().equals(username)).findFirst().orElse(null);

            if(haveTeam==null){
                System.out.printf("Team %s does not exist!%n", teamName);
            }
            else if(haveMember != null){
                System.out.printf("Member %s cannot join team %s!%n", username, teamName);
            }
            else {
                List<String> members = haveTeam.getMembers();
                members.add(username);
                haveTeam.setMembers(members);
            }

            input = scanner.nextLine();
        }
        projects.stream().filter(s -> s.getMembers().size()>0).sorted(Comparator.comparing(Project::numberOfMembers).reversed().thenComparing(Project::getProjectName)).forEach(System.out::println);
        System.out.println("Teams to disband:");
        projects.stream().filter(s -> s.getMembers().size()==0).sorted(Comparator.comparing(Project::getProjectName)).forEach(s -> System.out.println(s.getProjectName()));

    }
    public static class Project {
        private String projectName;
        private String creator;
        private List<String> members;

        public Project(String projectName, String creator) {
            this.projectName = projectName;
            this.creator = creator;
            this.members = new ArrayList<>();
        }
        public int numberOfMembers() {
            return members.size();
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public List<String> getMembers() {
            return members;
        }

        public void setMembers(List<String> members) {
            this.members = members;
        }

        @Override
        public String toString() {
            List <String> sortedList = this.members.stream().sorted().collect(Collectors.toList());
            String printMembers = "";
            for (String member: sortedList){
                printMembers += String.format("%n-- %s",member);
            }
            return String.format("%s%n" +
                    "- %s" +
                    "%s",this.projectName,this.creator,printMembers);
        }
    }
}
