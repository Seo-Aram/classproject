package util;

import lombok.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * config.json load 클래스.
 */
public class ConfigUtil {
    private Map<String, Object> config;
    private static ConfigUtil instance;

    private ConfigUtil() {
        config = new HashMap<>();

        JSONParser parser = new JSONParser();

        try {
            // 현재 경로에 따라 파일 오픈이 안되고 있음
            @Cleanup FileReader fr = new FileReader("config.json");
            Object obj = parser.parse(fr);
            JSONObject jsonConfig = (JSONObject) obj;

            Set<String> keys = jsonConfig.keySet();
            for(String key : keys) {
                this.config.put(key, jsonConfig.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConfigUtil getInstance() {
        if(instance == null) {
            instance = new ConfigUtil();
        }
        return instance;
    }

    public Object getConfig(String key) {
        return config.get(key);
    }
}
