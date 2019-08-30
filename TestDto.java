package apackage;


@Table("tb_test")
public class TestDto {
    @Deprecated
    private String tt;

    @Column("_id")
    private String id;

    @Column("username")
    private String name;

    public TestDto( String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
