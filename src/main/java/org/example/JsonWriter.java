package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JsonWriter {
    public static void writeToJson(Object object, String directory) throws Exception {
        String json = JsonUtil.serializeObject(object);
        String fileName = directory + "/req_" + new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date()) + ".json";

        File file = new File(fileName);
        file.getParentFile().mkdirs();

        try(FileWriter fileWriter = new FileWriter(fileName)){
            fileWriter.write(json);
        }
        System.out.println("JSON written to: " + fileName);
    }

    public static void writeToJsonList(List<Object> list, String directory) throws Exception {

        String json = JsonUtil.serializeListObjects(list);

        String fileName = directory + "/req_" + new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date()) + ".json";

        File file = new File(fileName);
        file.getParentFile().mkdirs();
        try(FileWriter fileWriter = new FileWriter(fileName)){
            fileWriter.write(json);
        }

        System.out.println("JSON written to: " + fileName);

    }
}
