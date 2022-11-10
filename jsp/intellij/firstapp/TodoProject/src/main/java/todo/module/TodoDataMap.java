package todo.module;

import java.time.LocalDate;
import java.util.*;

public class TodoDataMap {
    private static TodoDataMap instance;
    private Map<String, TodoData> map;
    private TodoDataMap() {
        map = new HashMap<>();
    }

    public static TodoDataMap getInstance() {
        if(instance == null) {
            instance = new TodoDataMap();
        }
        return instance;
    }

    public void initializeData() {
        if(map.size() == 0) {
            for(int i = 0; i < 10; ++i) {
                TodoData data = new TodoData("title" + i, LocalDate.now().toString());

                map.put(data.getKey(), data);
            }
        }
    }

    public void insertTodoData(TodoData data) {
        map.put(data.getKey(), data);
    }

    public TodoData getTodoData(String key) {
        return map.get(key);
    }

    public TodoData removeTodoData(String key) {
        return map.remove(key);
    }

    public void printAllLData() {
        Set<String> keys = map.keySet();
        for(String key : keys) {
            System.out.println(map.get(key));
        }
    }
}
