package dataModel;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

public class incident {

    private Long id;
    private String stanowisko;
    private Date data;
    private String[] godziny;

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String[] getGodziny() {
        return godziny;
    }

    public void setGodziny(String[] godziny) {
        this.godziny = godziny;
    }

    public incident() {
        // this form used by Hibernate
    }

    public incident(String stanowisko, Date data, String[] godziny) {
        // for application use, to create new events

        this.godziny = godziny;
        this.data = data;
        this.stanowisko = stanowisko;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

}
