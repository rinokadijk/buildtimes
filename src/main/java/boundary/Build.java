package boundary;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Build {
    private String scriptName;
    private String user;
    private int runtime;
    private boolean succes;

    public Build() {
    }

    public Build(String scriptName, String user, int runtime, boolean succes) {
        this.scriptName = scriptName;
        this.user = user;
        this.runtime = runtime;
        this.succes = succes;
    }

    public String getScriptName() {
        return scriptName;
    }

    public String getUser() {
        return user;
    }

    public int getRuntime() {
        return runtime;
    }

    public boolean isSucces() {
        return succes;
    }
}
