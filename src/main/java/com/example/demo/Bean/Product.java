package com.example.demo.Bean;

import java.util.List;

public class Product {
    private int statusCode;
    private String Message;
    private List<DataItem> Data;

    public int getStatusCode() { return statusCode; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }

    public String getMessage() { return Message; }
    public void setMessage(String Message) { this.Message = Message; }

    public List<DataItem> getData() { return Data; }
    public void setData(List<DataItem> Data) { this.Data = Data; }

    public static class DataItem {
        private String name;
        private String shortName;
        private String id;
        private boolean dataGrouping;
        private List<List<Double>> data;
    
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    
        public String getShortName() { return shortName; }
        public void setShortName(String shortName) { this.shortName = shortName; }
    
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
    
        public boolean isDataGrouping() { return dataGrouping; }
        public void setDataGrouping(boolean dataGrouping) { this.dataGrouping = dataGrouping; }
    
        public List<List<Double>> getData() { return data; }
        public void setData(List<List<Double>> data) { this.data = data; }
    }
}

