
package boundary;

import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CumulativeResult {

    private Map<String, Integer> durationPerScript;

    public CumulativeResult() {
        // Required by JAXB
    }

    public CumulativeResult(Map<String, Integer> durationPerScript) {
        this.durationPerScript = durationPerScript;
    }
    
}
