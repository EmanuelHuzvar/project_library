package sk.kasv.huzvar.library.member;

import sk.kasv.huzvar.library.db.Database;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
private List<Member> reader;


public Reader(){
    reader = new ArrayList<>();
}
public void readMemberFromDb(){
    reader = new Database().getAllMembers();
}
public int getNumberOfReader(){
    return reader.size();
}


}
