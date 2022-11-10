package todo.module;

import java.time.LocalDate;
import java.util.*;

public class TodoDataList {
    private static TodoDataList instance;
    private List<TodoData> list;
    private TodoDataList() {
        list = new ArrayList<>();
    }

    public static TodoDataList getInstance() {
        if(instance == null) {
            instance = new TodoDataList();
        }
        return instance;
    }

    public List<TodoData> getList() {
        return list;
    }

    public void initializeData() {
        if(list.size() == 0) {
            for(int i = 0; i < 10; ++i) {
                TodoData data = new TodoData("title" + i, LocalDate.now().toString());

                list.add(data);
            }
        }
    }

    public void insertTodoData(TodoData data) {
        list.add(data);
    }

    public TodoData getTodoData(String key) {
        int index = getIndex(key);
        if(index == -1) return null;
        return list.get(index);
    }

    private int getIndex(String key) {
        int index = -1;

        for(int i = 0; i < list.size(); ++i) {
            if(list.get(i).getKey().equals(key)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public TodoData removeTodoData(String key) {
        int index = getIndex(key);
        if(index == -1) return null;
        return list.remove(index);
    }

    public void updateTodoData(String key, String title, String date, boolean isCheck) {
        int index = getIndex(key);
        if(index == -1) return;
        TodoData findData = list.get(index);
        findData.setCheck(isCheck);
        findData.setDate(date);
        findData.setTitle(title);
    }

    public void printAllLData() {
        for(TodoData data : list) {
            System.out.println(data);
        }
    }
}
