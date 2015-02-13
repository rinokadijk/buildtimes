package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class BuildResult {

    @Id
    @GeneratedValue
    private Long id;
    private int duration;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String scriptName;
    private boolean succes;
    private String userName;

    public BuildResult() {
        // Required by JAXB
    }
    
    public BuildResult(String name, int duration, Date date, String user, boolean succes) {
        this.duration = duration;
        this.date = date;
        this.userName = user;
        this.scriptName = name;
        this.succes = succes;
    }

    public int getDuration() {
        return duration;
    }

    public Date getDate() {
        return date;
    }

    public String getScriptName() {
        return scriptName;
    }

    public boolean isSucces() {
        return succes;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "BuildResult{" +
                "id=" + id +
                ", duration=" + duration +
                ", date=" + date +
                ", scriptName='" + scriptName + '\'' +
                ", succes=" + succes +
                ", user='" + userName + '\'' +
                '}';
    }
}
