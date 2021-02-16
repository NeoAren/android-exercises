package eu.neoaren.exercise_6_1;

public class President {

    private final String name;
    private final String description;
    private final int startYear;
    private final int endYear;

    public President(String name, int startYear, int endYear, String description) {
        this.name = name;
        this.description = description;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIncumbency() {
        return this.startYear + " - " + this.endYear;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
