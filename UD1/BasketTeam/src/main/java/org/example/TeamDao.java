/*
package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TeamDao implements Dao<Team, String> {


    @Override
    public Team get(String id) {
        return null;
    }

    @Override
    public List<Team> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Team obxecto) {
        if (Files.exists(path)) {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream(path.toFile())));
            return true;
        }
        return false;
    }

    @Override
    public void delete(Team obx) {

    }

    @Override
    public void update(Team obx) {

    }
}
*/
