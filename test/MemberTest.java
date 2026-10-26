import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MemberTest {

    @Test
    void testGetMember(){
        //Arrange
        var member1 = new Member("Alma Exner", 10);
        //Act

        //Assert
        assertTrue("Alma Exner" == member1.getName());
    }
    @Test
    void testGetMemberFalse(){
        //Arrange
        var member1 = new Member("Alma Exner", 10);
        //Act

        //Assert
        assertTrue("" == member1.getName());
    }

    @Test
    void testGetID(){
        //Arrange
        var member1 = new Member("Alma Exner", 10);
        //Act

        //Assert
        assertTrue(10 == member1.getID());
    }

    @Test
    void testGetIDFalse(){
        //Arrange
        var member1 = new Member("Alma Exner", 10);
        //Act

        //Assert
        assertTrue(0 == member1.getID());
    }

    @Test
    void testToString(){
        //Arrange
        var member1 = new Member("Alma Exner", 10);
        //Act

        //Assert
        assertEquals(member1.getName() + " (Lånernummer: " + member1.getID() + ")", member1.toString());

    }

    @Test
    void testToStringFalse(){
        //Arrange
        var member1 = new Member("Alma Exner", 10);
        var member2 = new Member("", 0);
        //Act

        //Assert
        assertEquals(member1.getName() + " (Lånernummer: " + member1.getID() + ")", member2.toString());

    }

}
