package bootwildfly;

public class Response {

    private Long id;
    private String value;

    public Response(Long aId, String aValue) {
        this.id = aId;
        this.value = aValue;
    }

    public Long getId() { return this.id; }
    public String getValue() { return this.value; }

}
