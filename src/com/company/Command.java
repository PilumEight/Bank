package com.company;

import java.io.IOException;
import java.util.List;

abstract class Command {
    public String name;

    protected Command(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return name;
    }

    public abstract void execute(List<String> str_params) throws IOException, InterruptedException, CustomerNotFoundException;
}