package lapr.project.controller;

import java.sql.SQLException;
import java.util.List;

import lapr.project.data.PathDB;
import lapr.project.model.Path;

public class PathController {

    private final PathDB pDB;

    public PathController() {
        pDB = new PathDB();
    }

    public PathController(PathDB pdb) {
        this.pDB = pdb;
    }

    public boolean addPath(List<Path> p) throws SQLException {
        return pDB.addPath(p);
    }

    public boolean addPath(Path p) throws SQLException {
        return pDB.addPath(p);
    }

    public boolean removePath(Path p) throws SQLException {
        return pDB.removePath(p);

    }

    public List<Path> getAllPaths() {
        return pDB.getAllPaths();
    }

}
