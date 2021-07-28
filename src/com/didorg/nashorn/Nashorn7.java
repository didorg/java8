package com.didorg.nashorn;

import com.didorg.common.Person;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Nashorn7 {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("function foo(predicate, obj) { return !!(eval(predicate)); };");

        Invocable invocable = (Invocable) engine;

        Person person = new Person();
        person.setFirstName("Hans");

        String predicate = "obj.getLengthOfName() >= 4";
        Object result = invocable.invokeFunction("foo", predicate, person);
        System.out.println(result);
    }

}
