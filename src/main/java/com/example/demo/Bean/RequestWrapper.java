package com.example.demo.Bean;

import java.util.List;

public class RequestWrapper {
    private Req req;

    public RequestWrapper(Req req) {
        this.req = req;
    }

    public Req getReq() {
        return req;
    }

    public void setReq(Req req) {
        this.req = req;
    }

    public static class Req {
        private List<String> Keys;
        private String From;
        private String To;

        public Req(List<String> keys, String from, String to) {
            this.Keys = keys;
            this.From = from;
            this.To = to;
        }

        public List<String> getKeys() {
            return Keys;
        }

        public void setKeys(List<String> keys) {
            Keys = keys;
        }

        public String getFrom() {
            return From;
        }

        public void setFrom(String from) {
            From = from;
        }

        public String getTo() {
            return To;
        }

        public void setTo(String to) {
            To = to;
        }
    }
}
