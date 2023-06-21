/**
 * author:Administrator
 * createTime:2023/4/1716:40
 */
public class sut {
    private Integer id;
    private String name;

    public sut() {
    }

    public sut(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "sut{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
