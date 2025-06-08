package lab4_1;

public class SearchCondition {
    private Field field;
    private Relation relation;
    private String value;
    private Mode mode;
    private LogicOperator logicOperator;
    public SearchCondition() {
        this.field  = null;
        this.relation = null;
        this.mode = null;
        this.logicOperator = null;
        this.value = null;
    }
    public SearchCondition(Field field,  String value, Mode mode) {
        this.field = field;
//        this.relation = relation;
        this.value = value;
        this.mode = mode;
    }

    // Getters and Setters
    public Field getField() { return field; }
    public void setField(Field field) { this.field = field; }

    public Relation getRelation() { return relation; }
    public void setRelation(Relation relation) { this.relation = relation; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public Mode getMode() { return mode; }
    public void setMode(Mode mode) { this.mode = mode; }

    public LogicOperator getLogicOperator() { return logicOperator; }
    public void setLogicOperator(LogicOperator logicOperator) { this.logicOperator = logicOperator; }

    @Override
    public String toString() {
        return field + " " + relation + " '" + value + "' (" + mode + ")";
    }
}