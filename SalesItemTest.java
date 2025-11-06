import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void testFindMostHelpfulComment(){
    SalesItem item = new SalesItem("Keyboard", 5000);
    
    item.addComment("Alex", "Good ", 4);
    item.addComment("Ben", "Okay", 3);
    item.addComment("Cara", "Very goog", 5);
    
    item.upvoteComment(1);
    item.upvoteComment(2);
    item.upvoteComment(2);
    
    Comment mostHelpful = item.findMostHelpfulComment();
    assertEquals("Cara", mostHelpful.getAuthor());
    
    
    }
    
    @Test
    public void mostHelpfulCommentIsNullWhenNOComments(){
    SalesItem item = new SalesItem("Keyboard", 5000);
    
    Comment mostHelpful = item.findMostHelpfulComment();
    
    assertNull(mostHelpful);
    
    
    }    
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
      */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void duplicateAuthorIsRejected() {
        SalesItem item = new SalesItem("Keyboard", 5000);
        assertTrue(item.addComment("Alex", "Good keyboard", 4));
        assertFalse(item.addComment("Alex", "Another opinion", 5));
        assertEquals(1, item.getNumberOfComments());
    
    
    }
    
    
    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    @Test
    public void ratingsJustOutsideAreRejected() {
    SalesItem item = new SalesItem("Keyboard", 5000);
    assertFalse(item.addComment("A", "bad rating low", 0));
    assertFalse(item.addComment("B", "bad rating high", 6));
    assertEquals(0, item.getNumberOfComments());
    }
    
    
    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }
}
