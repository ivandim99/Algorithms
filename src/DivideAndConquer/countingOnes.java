package DivideAndConquer;

import javax.sound.midi.SysexMessage;

class Skill {

    private String name;

    private boolean completed;

    public Skill(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }
    public boolean isCompleted() {
        return completed;
    }
}


public class countingOnes {

    /**
     * You should implement this method.
     *
     * @param n the number of elements in skills.
     * @param skills the sorted array of `Skill`s (see Library for their implementation) to look
     *     through. Note that you should use entries skills[1] to skills[n]!
     * @return the number of completed skills in the sorted array.
     */
    public static int numberOfCompletedSkills(int n, Skill[] skills) {
        return numberOfCompletedSkills(skills,1,n);
    }

    public static int numberOfCompletedSkills(Skill[] skills,int low,int high) {
        if(!skills[high].isCompleted()) {
            return 0;
        }
        if(skills[low].isCompleted()){
            return high - low + 1;
        }
        int mid = (low + high) / 2;
        int left = numberOfCompletedSkills(skills,low,mid);
        int right = numberOfCompletedSkills(skills,mid + 1,high);
        return left + right;

    }
}
