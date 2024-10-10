package org.example;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class RunJSScript {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("uso: java Main index.js");
            return;
        }

        ScriptEngineManager manager = new ScriptEngineManager(null);

        ScriptEngine engine = manager.getEngineByName("ECMAScript");

        try {
            engine.eval(new FileReader(args[0]));
        } catch (ScriptException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}