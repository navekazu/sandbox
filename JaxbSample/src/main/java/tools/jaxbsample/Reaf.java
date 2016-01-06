package tools.jaxbsample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

// see -> http://qiita.com/opengl-8080/items/f7112240c72d61d4cdf4
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reaf {
    private List<Reaf> childList = new ArrayList<>();
    private Map<String, String> values = new LinkedHashMap<>();  // 格納順を保持したいのでLinkedHashMapを使用

    public void putValue(String key, String value) {
        values.put(key, value);
    }

    public String getValue(String key) {
        return values.get(key);
    }

    public void removeValue(String key) {
        values.remove(key);
    }

    public void addChild(Reaf reaf) {
        childList.add(reaf);
    }
}