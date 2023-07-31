package org.example;


import org.testng.annotations.Test;


public class Runner {

    CreateABoard cb;
    CreateAList cl;
    CreateACard cc;
    AddAComment ac;
    GetABoard gb;
    GetLists gl;
    UpdateBoard ub;
    MoveAList ml;
    ArchiveAList al;
    DeleteABoard db;

    public Runner() {
        cb = new CreateABoard();
        cl = new CreateAList();
        cc = new CreateACard();
        ac = new AddAComment();
        gb = new GetABoard();
        gl = new GetLists();
        ub = new UpdateBoard();
        ml = new MoveAList();
        al = new ArchiveAList();
        db = new DeleteABoard();

    }

    @Test(priority = 1)
    public void firstBoard() {

        cb.createaBoard("1st Board","{\"name\":\"create1stBoard\"}");
        cl.createalist(CreateABoard.id1, "First Things First");
        cc.createacard(CreateAList.id1);
        ac.addacomment(CreateACard.id1, "this is a text written by khaled on a card");

    }

    @Test(priority = 2)
    public void secondBoard() {
        cb.createaBoard("2nd Board","{\"name\":\"create2ndBoard\"}");
        cl.createalist(CreateABoard.id2, "Second Thing");
        cc.createacard(CreateAList.id2);
        ac.addacomment(CreateACard.id2, "this is a text written on the second board");
    }

    @Test(priority = 3)
    public void updateABoard() {
        ub.updateBoard(CreateABoard.id1, "First Board");
        ub.updateBoard(CreateABoard.id2, "Second Board");
    }

    @Test(priority = 4)
    public void getBoard() {
        gb.getaboard(CreateABoard.id1);
    }

    @Test(priority = 5)
    public void getlists() {
        gl.getlists(CreateABoard.id1);
    }

    @Test(priority = 6 )
    public void moveList() {
        ml.moveAList(GetLists.listid.get(1), CreateABoard.id2);
    }

    @Test(priority = 7 )
    public void archiveList() {
        al.archiveAList(GetLists.listid.get(2));
    }

    @Test(priority = 8)
    public void deleteABoard()  {
        db.deleteABoard(CreateABoard.id2);
    }

    @Test(priority = 9)
    public void lastBoard() {
        cb.createaBoard("Technically The Second Board","{\"name\":\"createAnotherBoard\"}");
        cl.createalist(CreateABoard.id2, "A New List");
        cc.createacard(CreateAList.id2);
        ac.addacomment(CreateACard.id2, "this is a text written in the new board");
    }


}
