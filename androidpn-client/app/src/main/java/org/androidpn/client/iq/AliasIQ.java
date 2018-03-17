package org.androidpn.client.iq;

import org.jivesoftware.smack.packet.IQ;

public class AliasIQ extends IQ {
    private AliasIQ() {
    }

    public enum Singleton {
        INSTANCE;
        private AliasIQ aliasIQ = null;
        Singleton() {
            aliasIQ = new AliasIQ();
        }

        public AliasIQ get() {
            return aliasIQ;
        }
    }


    private String username;
    private String alias;

    @Override
    public String getChildElementXML() {
        StringBuilder buf = new StringBuilder();
        buf.append("<").append("setalias").append(" xmlns=\"").append(
                "androidpn:iq:setalias").append("\">");
        if (username != null) {
            buf.append("<username>").append(username).append("</username>");
        }
        if (alias != null) {
            buf.append("<alias>").append(alias).append("</alias>");
        }
        buf.append("</").append("setalias").append("> ");
        return buf.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
