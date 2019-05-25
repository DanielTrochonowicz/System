package system.Issue;

public enum IssueType {
    CRITICAL("CRITICIAL"),
    WORK("PRACA"),
    ANALISIS("ANALIZA"),
    ERROR("ERROR");


    private String typeNAme;

    IssueType(String typeNAme) {
        this.typeNAme = typeNAme;
    }
    public String getTypeNAme() {
        return typeNAme;
    }
}
