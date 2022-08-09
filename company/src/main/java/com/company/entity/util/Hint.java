package com.company.entity.util;

public class Hint {
    private String hint;

    public Hint() {
    }

    public Hint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public String toString() {
        return "Hint{" +
                "hint='" + hint + '\'' +
                '}';
    }
}
